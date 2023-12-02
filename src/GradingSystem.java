/**
 * The GradingSystem class provides a default grading system for all modules.
 * It includes a method to determine the corresponding grade based on a given percentage score.
 */
public class GradingSystem {

    /**
     * Constructs a new GradingSystem, representing the default grading system for all modules.
     */
    public GradingSystem() {
    }

    /**
     * Gets the grade based on the given percentage score.
     *
     * @param gradeInPercentage The percentage score for which to determine the grade.
     * @return The corresponding grade based on the provided percentage score.
     *         Returns "F" for failure, "D2", "D1", ..., "A1" for passing grades.
     *         Returns "NG" for scores outside the defined range.
     *         Returns "Error" if an unexpected error occurs during the calculation.
     */
    public static String getGrade(Double gradeInPercentage) {
        try {
            Double score = gradeInPercentage;
            Double[] gradeScores = {0.0, 30.0, 35.0, 40.0, 45.0, 50.0, 55.0, 60.0, 65.0, 70.0, 75.0, 101.0};
            String[] grades = {"F", "D2", "D1", "C3", "C2", "C1", "B3", "B2", "B1", "A2", "A1"};
            
            for (int i = 0; i < gradeScores.length - 1; i++) {
                if (score >= gradeScores[i] && score < gradeScores[i + 1]) {
                    return grades[i];
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return "NG";
        }
        return "Error";
    }
}