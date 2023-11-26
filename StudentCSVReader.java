import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class StudentCSVReader {
    private HashMap<Integer, Student> studentIDMap;

    public StudentCSVReader() {
        studentIDMap = new HashMap<>();
    }

    public HashMap<Integer, Student> getStudentMap() {
        return studentIDMap;
    }

    public void readStudents(String csvFilePath, ProgrammeList programmeList) {
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
    
                Student student = new Student(name, email, programme, year, semester);
                programme.addStudentToProgram(student);
    
                studentIDMap.put(studentID, student);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }    
}
