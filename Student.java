public class Student extends Person {
    private int studentID;
    private Programme programme;
    private int year;
    
    public Student(String name, String email, Programme programme, int year) {
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
    //viewTranscript
}




