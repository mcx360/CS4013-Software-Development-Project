import java.util.List;

public class Student extends Person implements Comparable<Student>{
    private int studentID;
    private Programme programme;
    private int year;
    private int semester;
    private double thesis;
    
    public Student(String name, String email, Programme programme, int year, int semester) {
        super(name, email);
        this.programme = programme;
        this.year = year;

        int syntaxConfirmation = email.indexOf('@');
        if (syntaxConfirmation != -1) {
            String studentIDstring = email.substring(0, syntaxConfirmation);
            try {
                this.studentID = Integer.parseInt(studentIDstring);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid student ID Format");
            }
        } else {
            throw new IllegalArgumentException("Invalid Email Format");
        }

        this.semester = semester;
        this.thesis = 0.00;
    }

    public int getYear () {
        return this.year;
    }
    
    public void setYear (int year) {
        this.year = year;
    }

    public int getID () {
        return this.studentID;
    }

    public Programme getProgramme () {
        return this.programme;
    }

    public int getSemester () {
        return this.semester;
    }

    public void setSemester (int semester) {
        this.semester = semester;
    }

    public void setThesis (double result) {
        this.thesis = result;
    }

    public double getThesis () {
        return this.thesis;
    }

    public int calculateTotalCredits (Student student) {
    List<Module> modules = programme.getModules(this.year, this.semester);
    int totalCredits = 0;

    for (Module module : modules) {
        if (module.getStudentGrade(student) != null) {
            totalCredits += module.getCredits();
            }
        }
        return totalCredits;
    }

    public int calculateTotalStudentCredits (Student student) {
    List<Module> modules = programme.getModules(this.year, this.semester);
    int totalCredits = 0;

    for (Module module : modules) {
        if (module.getStudentGrade(student) != null && module.getStudentGrade(student) != "NG" && module.getStudentGrade(student) != "F") {
            totalCredits += module.getCredits();
            }
        }
        return totalCredits;
    }

    //calculateQca
    public double calculateQCAForCurrentSemester (Student student) {
    List<Module> modules = programme.getModules(this.year, this.semester);
    int index = modules.size();
    double sum = 0.0;

    for (Module module : modules) {
        if (module.getStudentGrade(student) == null) {
            index--;
        } else {
            String grade = module.getStudentGrade(student);
            double QCAgrade = module.getStudentGradeDouble(grade);
            sum += QCAgrade;
        }
    }

    if (index == 0) {
        return 0.0; 
    }

    return sum / index;
    }

    public double calculateQCAForSemester (Student student, int year, int semester) {
    List<Module> modules = programme.getModules(year, semester);
    int index = modules.size();
    double sum = 0.0;

    for (Module module : modules) {
        if (module.getStudentGrade(student) == null) {
            index--;
        } else {
            String grade = module.getStudentGrade(student);
            double QCAgrade = module.getStudentGradeDouble(grade);
            sum += QCAgrade;
        }
    }

    if (index == 0) {
        return 0.0; // To avoid division by zero if no valid grades are found
    }

    return sum / index;
    }

    public double calculateQCAForYear (Student student) {
        double semester1 = calculateQCAForSemester(student, this.year, 1);
        double semester2 = calculateQCAForSemester(student, this.year, 2);
        return (semester1 + semester2)/2;
    }

    public double calculateTotalAverageQCA (Student student) {
        int yearCount = 0;
        int semesterCount = 0;
        double QCA = 0.00;
        while (this.semester != semesterCount && this.year != yearCount) {
            QCA += calculateQCAForSemester(student, yearCount, semesterCount);
            yearCount++;
            semesterCount++;
        }
        return QCA;
    }

    @Override
    public int compareTo(Student other){
        return Integer.compare(this.studentID, other.studentID);
    }

    /*programme has (year, semester) as key to modules[]
    modules may contain 10 modules
    but student can only pick 5
    so other 5 will be 0 grade
    add up all modules
    take away number of modules with grade N/A from indexOf
    divide sum by index
    */


    //viewTranscript
    public String viewTranscript() {
        StringBuilder transcript = new StringBuilder();
        transcript.append("Programme: ").append(programme.getProgrammeName())
                .append("\n")
                .append("Student Name: ").append(getName())
                .append("\n");
    
        double totalQCA = 0.0; // Variable to store total QCA
    
        // Loop through each completed year and semester
        for (int year = 1; year <= getYear(); year++) {
            for (int sem = 1; sem <= 2; sem++) {
                if ((year < getYear()) || (year == getYear() && sem <= getSemester())) {
                    transcript.append("\n").append("+----------------------+-------------------+\n")
                            .append("| Year: ").append(year).append("     Semester: ").append(sem).append("       |\n")
                            .append("+----------------------+-------------------+\n")
                            .append("| Module               | Grade   |  QCA    |\n");
    
                    List<Module> modules = programme.getModules(year, sem);
                    for (Module module : modules) {
                        String grade = module.getStudentGrade(this);
                        if (grade != null) {
                            double qca = calculateQCAForSemester(this, year, sem);
                            transcript.append("| - ").append(module.getModuleName()).append(" (").append(module.getModuleCode()).append(")")
                                    .append("   | ").append(grade).append("      | ").append(String.format("%.2f", qca)).append("  |\n");
                        }
                    }
                    double semesterQCA = calculateQCAForSemester(this, year, sem);
                    transcript.append("+----------------------+-------------------+\n")
                            .append("| Semester QCA: ").append(String.format("%.2f", semesterQCA)).append("       |\n")
                            .append("+----------------------+-------------------+\n");
    
                    totalQCA += semesterQCA; // Accumulate total QCA for all semesters
                }
            }
        }
    
        // Display the total QCA for all semesters
        transcript.append("\n").append("Total QCA for all semesters: ").append(String.format("%.2f", totalQCA)).append("\n");
    
        return transcript.toString();
    }
    
}