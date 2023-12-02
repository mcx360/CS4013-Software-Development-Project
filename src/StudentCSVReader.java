import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * The `StudentCSVReader` class reads student information from a CSV file and populates a HashMap with student IDs
 * as keys and corresponding `Student` objects as values. It also associates each student with the appropriate
 * academic program in a `ProgrammeList`.
 */
public class StudentCSVReader {

    private HashMap<Integer, Student> studentIDMap;

    /**
     * Constructs a new `StudentCSVReader` with an empty student ID map.
     */
    public StudentCSVReader() {
        studentIDMap = new HashMap<>();
    }

    /**
     * Retrieves the student ID map containing student IDs as keys and corresponding `Student` objects as values.
     *
     * @return The student ID map.
     */
    public HashMap<Integer, Student> getStudentMap() {
        return studentIDMap;
    }

    /**
     * Reads student information from a CSV file, associates each student with the appropriate academic program
     * in a `ProgrammeList`, and populates the student ID map.
     *
     * @param csvFilePath   The path to the CSV file containing student information.
     * @param programmeList The `ProgrammeList` containing academic programs.
     */
    public void readStudents(String csvFilePath, ProgrammeList programmeList) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            String splitSymbol = ",";

            // Skip the header line in the CSV file
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(splitSymbol);

                String name = data[0];
                String email = data[1];
                int studentID;

                int syntaxConfirmation = email.indexOf('@');
                if (syntaxConfirmation != -1 && syntaxConfirmation != 0 && syntaxConfirmation != email.length() - 1) {
                    String studentIDstring = email.substring(0, syntaxConfirmation);
                    try {
                        studentID = Integer.parseInt(studentIDstring);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid student ID Format");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid Email Format");
                }

                int semester = Integer.parseInt(data[2]);
                int year = Integer.parseInt(data[3]);

                String programmeName = data[4];
                Programme programme = programmeList.findProgrammeByName(programmeName);
                if (programme == null) {
                    throw new IllegalArgumentException("Programme not found: " + programmeName);
                }

                // Create a new Student object and add it to the associated academic program
                Student student = new Student(name, email, programme, year, semester);
                programme.addStudentToProgram(student);

                // Populate the student ID map
                studentIDMap.put(studentID, student);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
