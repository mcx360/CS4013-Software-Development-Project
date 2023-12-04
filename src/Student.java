import java.util.List;

/**
 * The `Student` class represents a student in an academic program. It extends the `Person` class and implements
 * the `Comparable` interface for sorting purposes. It includes methods for managing student details,
 * calculating QCA (Quality Credit Average), and generating a transcript.
 */
public class Student extends Person implements Comparable<Student> {

    private int studentID;
    private Programme programme;
    private int year;
    private int semester;
    private double thesis;

    /**
     * Constructs a new `Student` with the specified details.
     *
     * @param name      The name of the student.
     * @param email     The email of the student, used to extract the student ID.
     * @param programme The academic program in which the student is enrolled.
     * @param year      The current academic year of the student.
     * @param semester  The current academic semester of the student.
     */
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

    /**
     * Retrieves the current academic year of the student.
     *
     * @return The current academic year.
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Sets the current academic year of the student.
     *
     * @param year The new academic year to set.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Retrieves the student ID.
     *
     * @return The student ID.
     */
    public int getID() {
        return this.studentID;
    }

    /**
     * Retrieves the academic program of the student.
     *
     * @return The academic program.
     */
    public Programme getProgramme() {
        return this.programme;
    }

    /**
     * Retrieves the current academic semester of the student.
     *
     * @return The current academic semester.
     */
    public int getSemester() {
        return this.semester;
    }

    /**
     * Sets the current academic semester of the student.
     *
     * @param semester The new academic semester to set.
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * Sets the thesis result for the student.
     *
     * @param result The result of the thesis.
     */
    public void setThesis(double result) {
        this.thesis = result;
    }

    /**
     * Retrieves the thesis result of the student.
     *
     * @return The thesis result.
     */
    public double getThesis() {
        return this.thesis;
    }

    /**
     * Calculates the total credits completed by the student for a specific semester.
     *
     * @param student The student for whom to calculate total credits.
     * @return The total credits completed.
     */
    public int calculateTotalCredits(Student student) {
        List<Module> modules = programme.getModules(this.year, this.semester);
        int totalCredits = 0;

        for (Module module : modules) {
            if (module.getStudentGrade(student) != null) {
                totalCredits += module.getCredits();
            }
        }
        return totalCredits;
    }

    /**
     * Calculates the total valid credits (excluding "NG" and "F" grades) completed by the student for a specific semester.
     *
     * @param student The student for whom to calculate total valid credits.
     * @return The total valid credits completed.
     */
    public int calculateTotalStudentCredits(Student student) {
        List<Module> modules = programme.getModules(this.year, this.semester);
        int totalCredits = 0;

        for (Module module : modules) {
            if (module.getStudentGrade(student) != null && !module.getStudentGrade(student).equals("NG") && !module.getStudentGrade(student).equals("F")) {
                totalCredits += module.getCredits();
            }
        }
        return totalCredits;
    }

    /**
     * Calculates the QCA (Quality Credit Average) for the current semester of the student.
     *
     * @param student The student for whom to calculate the QCA.
     * @return The QCA for the current semester.
     */
    public double calculateQCAForCurrentSemester(Student student) {
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

    /**
     * Calculates the QCA for a specific semester of the student.
     *
     * @param student  The student for whom to calculate the QCA.
     * @param year     The academic year of the semester.
     * @param semester The academic semester.
     * @return The QCA for the specified semester.
     */
    public double calculateQCAForSemester(Student student, int year, int semester) {
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

    /**
     * Calculates the QCA for the entire academic year of the student.
     *
     * @param student The student for whom to calculate the QCA.
     * @return The QCA for the entire academic year.
     */
    public double calculateQCAForYear(Student student) {
        double semester1 = calculateQCAForSemester(student, this.year, 1);
        double semester2 = calculateQCAForSemester(student, this.year, 2);
        return (semester1 + semester2) / 2;
    }

    /**
     * Calculates the total average QCA for the student across all completed semesters.
     *
     * @param student The student for whom to calculate the total average QCA.
     * @return The total average QCA for all completed semesters.
     */
    public double calculateTotalAverageQCA(Student student) {
        double totalQCA = 0.0;
        int numberOfSemestersInYear = 2; 

        int currentYear = student.getYear();
        int currentSemester = student.getSemester();

        for (int year = 1; year <= currentYear; year++) {
            int maxSemester = numberOfSemestersInYear;

            if (year == currentYear) {
                maxSemester = currentSemester;
            }

            for (int semester = 1; semester <= maxSemester; semester++) {
                totalQCA += calculateQCAForSemester(student, year, semester);
            }
        }

        return totalQCA;
    }



    /**
     * method for the student comparator
     */
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
    /**
     * 
     * @return a string representation of the students transcript, showing all releveant information concerning the student
     * 
     */
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
                    transcript.append("\n").append("+----------------------+----------+\n")
                            .append("| Year: ").append(year).append("     Semester: ").append(sem).append("       |\n")
                            .append("+----------------------+----------+\n")
                            .append("| Module Code          | Grade    |\n");

                    List<Module> modules = programme.getModules(year, sem);
                    for (Module module : modules) {
                        String grade = module.getStudentGrade(this);
                        if (grade != null) {
                            transcript.append("| - ").append(module.getModuleCode()) 
                                    .append("   | ").append(grade).append("      |")
                                    .append(module.getStudentGradeDouble(grade))
                                    .append("\n");
                        }
                    }

                    double semesterQCA = calculateQCAForSemester(this, year, sem);
                    transcript.append("+----------------------+----------+\n")
                            .append("| Semester QCA: ").append(String.format("%.2f", semesterQCA)).append("       |\n")
                            .append("+----------------------+----------+\n");

                    totalQCA += semesterQCA; // Accumulate total QCA for all semesters
                }
            }
        }

        // Display total QCA for all completed semesters
        transcript.append("\nTotal QCA: ").append(String.format("%.2f", totalQCA)).append("\n");
        return transcript.toString();
    }

}
