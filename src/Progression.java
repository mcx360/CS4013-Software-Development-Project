/**
 * The `Progression` class represents the academic progression and graduation eligibility of a student.
 * It includes methods to check and update the graduation status as well as progress the student to the next academic level.
 */
public class Progression {

    private Student student;
    private int level;
    private boolean graduationEligibility;

    /**
     * Constructs a new `Progression` object for the specified student.
     *
     * @param student The student for whom the progression is being tracked.
     */
    public Progression(Student student) {
        this.student = student;
        Programme programme = student.getProgramme();
        level = programme.getProgrammeLevel();
        this.graduationEligibility = false;
    }

    /**
     * Checks the graduation status of the associated student based on academic criteria.
     *
     * @return True if the student is eligible for graduation, false otherwise.
     */
    public boolean getGraduationStatus() {
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

    /**
     * Progresses the student to the next academic level if the average QCA is greater than or equal to 2.00.
     * If the student is in the second semester, it increments the year; otherwise, it sets the semester to 2.
     */
    public String progressStudent() {
        if (student.getSemester() == 2) {
            if (student.calculateTotalAverageQCA(student) < 2.00) {
                return "failed";
            } else {
                student.setYear(student.getYear() + 1);
                return "progressed to next year";
            }
        } else {
            if (student.calculateTotalAverageQCA(student) < 2.00) {
                return "failed";
            } else {
                student.setSemester(2);
                return "progressed to next semester";
            }
        }
    }
}


