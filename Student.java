public class Student extends Person {
    private int studentID;
    private Programme programme;
    private int year;
    private int semester;
    
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
                throw new IllegalAccessException("Invalid Email Format");
            }

        this.semester = semester;
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
    public double calculateQca () {
        Module modules[] = programme.getModules(this.year, this.semester);
        int index = modules.length;
        double sum = 0.0;

        for (int i = 0; i < modules.length; i++) {
            if (modules[i].getStudentGrade(this.studentID) == NULL) {
                index--;
            } else {
                sum += modules[i].getStudentGrade(this.studentID);
            }
        }
        return sum/index;
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




