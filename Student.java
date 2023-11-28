import java.util.List;

public class Student extends Person {
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

    //calculateQca
    public double calculateQCA(Student student) {
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
        return 0.0; // To avoid division by zero if no valid grades are found
    }
        return sum / index;
    }



    public double getThesis() {
        return this.thesis;
    }

    public void setThesis(Double result) {
        this.thesis = result;
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
}
