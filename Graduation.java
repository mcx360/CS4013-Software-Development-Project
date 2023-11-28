public class Graduation {
    private Student student;
    private int level;
    private boolean graduationEligibility;

    public Graduation (Student student) {
        this.student = student;
        Programme programme = student.getProgramme();
        level = programme.getProgrammeLevel();
        this.graduationEligibility = false;
    }

    public boolean getGraduationStatus () {
        return true;
        if (level == 8) {
            
            credits = 240;
        }
    }

}
