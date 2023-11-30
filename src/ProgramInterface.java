import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramInterface {
    private Scanner scanner;

    public ProgramInterface() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("Choose an option:");
            System.out.println("(S)tudent");
            System.out.println("(F)aculty");
            System.out.println("(U)pload");
            System.out.println("(R)emove");
            System.out.println("(Q)uit");

            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "S":
                    studentOptions();
                    break;
                case "F":
                    facultyOptions();
                    break;
                case "U":
                    uploadOptions();
                    break;
                case "R":
                    removeOptions();
                    break;
                case "Q":
                    continueRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }

    private void studentOptions() {
        System.out.println("Enter Student Id:");
        int studentId = scanner.nextInt();
        try{
        System.out.println("Student Options:");
        System.out.println("1. View Transcript (Own)");
        System.out.println("2. Get Graduation Status");
        System.out.println("3. Back");

        String studentChoice = scanner.nextLine();

        switch (studentChoice) {
            case "1":
                
                break;
            case "2":
                // Get Graduation Status
                // Implement functionality here
                break;
            case "3":
                break;
            default:
                System.out.println("Invalid option for students.");
                break;
        }
    }catch(InputMismatchException e ){
        System.out.println("Invalid format for studentId. Student id must be only in numeric form");
    }catch(NullPointerException e){
        System.out.println("This student does not exist, make sure you have typed in the student id correctly");
    }
    }

    private void facultyOptions() {
        System.out.println("Faculty Options:");
        System.out.println("1. Get Student Name");
        System.out.println("2. Set Student Grade");
        System.out.println("3. View Students in Module");
        System.out.println("4. Progress Student");
        System.out.println("5. Get Graduation Status");
        System.out.println("6. View Transcript");
        System.out.println("7. Get Module Average");
        System.out.println("8. View All Department Programmes");
        System.out.println("9. Get Average Programme QCA");
        System.out.println("10. Exam Board Options");
        System.out.println("11. Back");

        String facultyChoice = scanner.nextLine();

        switch (facultyChoice) {
            case "1":
                // Get Student Name
                // Implement functionality here
                break;
            case "2":
                // Set Student Grade
                // Implement functionality here
                break;
            case "3":
                // View Students in Module
                // Implement functionality here
                break;
            case "4":
                // Progress Student
                // Implement functionality here
                break;
            case "5":
                // Get Graduation Status
                // Implement functionality here
                break;
            case "6":
                // View Transcript
                // Implement functionality here
                break;
            case "7":
                // Get Module Average
                // Implement functionality here
                break;
            case "8":
                // View All Department Programmes
                // Implement functionality here
                break;
            case "9":
                // Get Average Programme QCA
                // Implement functionality here
                break;
            case "10":
                // Exam Board Options
                // Implement functionality here
                break;
            case "11":
                break;
            default:
                System.out.println("Invalid option for faculty.");
                break;
        }
    }

    private void uploadOptions() {
        System.out.println("Upload Options:");
        System.out.println("1. Add Student to Module");
        System.out.println("2. Add Module");
        System.out.println("3. Add Programme");
        System.out.println("4. Add Student to Programme");
        System.out.println("5. Add Department");
        System.out.println("6. Add Faculty");
        System.out.println("7. Back");

        String uploadChoice = scanner.nextLine();

        switch (uploadChoice) {
            case "1":
                // Add Student to Module
                // Implement functionality here
                break;
            case "2":
                // Add Module
                // Implement functionality here
                break;
            case "3":
                // Add Programme
                // Implement functionality here
                break;
            case "4":
                // Add Student to Programme
                // Implement functionality here
                break;
            case "5":
                // Add Department
                // Implement functionality here
                break;
            case "6":
                // Add Faculty
                // Implement functionality here
                break;
            case "7":
                break;
            default:
                System.out.println("Invalid option for upload.");
                break;
        }
    }

    private void removeOptions() {
        System.out.println("Remove Options:");
        System.out.println("1. Remove Student from Module");
        System.out.println("2. Remove Module");
        System.out.println("3. Remove Student from Programme");
        System.out.println("4. Remove Programme");
        System.out.println("5. Remove Department");
        System.out.println("6. Remove Faculty");
        System.out.println("7. Back");

        String removeChoice = scanner.nextLine();

        switch (removeChoice) {
            case "1":
                // Remove Student from Module
                // Implement functionality here
                break;
            case "2":
                // Remove Module
                // Implement functionality here
                break;
            case "3":
                // Remove Student from Programme
                // Implement functionality here
                break;
            case "4":
                // Remove Programme
                // Implement functionality here
                break;
            case "5":
                // Remove Department
                // Implement functionality here
                break;
            case "6":
                // Remove Faculty
                // Implement functionality here
                break;
            case "7":
                break;
            default:
                System.out.println("Invalid option for remove.");
                break;
        }
    }

}