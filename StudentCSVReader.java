import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StudentCSVReader {
    private HashMap<Integer, Student> studentIDMap;

    public StudentCSVReader() {
        studentIDMap = new HashMap<>();
    }

    public HashMap<Integer, Student> getStudentMap() {
        return studentIDMap;
    }

    public void readStudents(String csvFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            String splitSymbol = ",";

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(splitSymbol);

                String name = data[0];
                String email = data[1];
                int studentID;

                int syntaxConfirmation = email.indexOf('@');
                if (syntaxConfirmation != -1) {
                    String studentIDstring = email.substring(0, syntaxConfirmation);
                    try {
                        studentID = Integer.parseInt(studentIDstring);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid student ID Format");
                    }
                } else {
                        throw new IllegalAccessException("Invalid Email Format");
                    }

                Programme programme = new Programme(data[2]);
                int year = Integer.parseInt(data[3]);

                Student student = new Student(name, email, programme, year);

                studentIDMap.put(studentID, student);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
