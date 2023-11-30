public class Progression {
    private Student student;
    private int level;
    private boolean graduationEligibility;

    public Progression (Student student) {
        this.student = student;
        Programme programme = student.getProgramme();
        level = programme.getProgrammeLevel();
        this.graduationEligibility = false;
    }

    public boolean getGraduationStatus () {
        this.graduationEligibility = false;
        double studentQCA = student.calculateTotalAverageQCA(student);
        double thesis = student.getThesis();
        int creditsRequired = student.calculateTotalCredits(student);
        int creditsAcquired = student.calculateTotalStudentCredits(student);

        if (level == 8) {
            if (studentQCA >= 2.00 && creditsAcquired >= creditsRequired) {
                this.graduationEligibility = true;
            }
        } else if (level == 9 && creditsAcquired >= creditsRequired) {
            if (studentQCA >= 2.00 && thesis >= 2.00) {
                this.graduationEligibility = true;
            }
            } else if (level == 10 && creditsAcquired >= creditsRequired) {
                if (studentQCA >= 3.00 && thesis >= 3.00) {
                    this.graduationEligibility = true;
                }
            }
            return this.graduationEligibility;
        }

    public void progressStudent () {
        if (student.calculateTotalAverageQCA(student) >= 2.00) {
            if (student.getSemester() == 2) {
                student.setYear(student.getYear() + 1);
            } else {
                student.setSemester(2);
            }
        }
    }

}
