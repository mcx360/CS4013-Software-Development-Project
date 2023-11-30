import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ProgramInterface {
    private Scanner scanner;

    public ProgramInterface() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean continueRunning = true;
        FacultyList facultyList = new FacultyList();

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
        System.out.println("6. Back");

        String uploadChoice = scanner.nextLine();

        switch (uploadChoice) {
            case "1":
                // Add Student to Module
                // Implement functionality here
                break;
            case "2":
                // Add Module
                // Implement functionality here
                System.out.println("Enter module name: ");
                String moduleName = scanner.nextLine();
                System.out.println("Enter module code: ");
                String moduleCode = scanner.nextLine();
                System.out.println("Enter module credits: ");
                int moduleCredits = scanner.nextInt();
                System.out.println("Enter professor name: ");
                String professorName = scanner.nextLine();
                System.out.println("Which year is this module taken at: ");
                int year = scanner.nextInt();
                System.out.println("Which semester is this module taken at: ");
                int semester = scanner.nextInt();
                System.out.println("Which programme does this module belong to: ");
                String programmeName = scanner.nextLine();
                Programme programme = department.findProgrammeByName(programmeName);

                Module module = new Module(departmentName, moduleCode, moduleCredits, programme, professorName, year, semester);
                programme.addModule(year, semester, module);

                System.out.println("Module successfully created");
                break;
            case "3":
                // Add Programme
                // Implement functionality here
                System.out.println("Enter Programme name: ");
                String programmeName = scanner.nextLine();
                System.out.println("Enter programme duration: ");
                int duration = scanner.nextInt();
                System.out.println("Enter Programme level:");
                int programmeLevel = scanner.nextInt();
                
                System.out.println("Which department does this programme belong to: ");
                String departmentName = scanner.nextLine();
                Department department = Faculty.findDepartmentByName(departmentName);
                Programme programme = new Programme(programmeNameName,duration,programmeLevel, department);
                department.addProgramme(programme);

                System.out.println("Department successfully created");
                break;
            case "4":
                // Add Student to Programme
                // Implement functionality here
                System.out.println("Enter student name: ");
                String studentName = scanner.nextLine();
                System.out.println("Enter student email: ");
                String studentEmail = scanner.nextLine();
                System.out.println("Enter programme student is enrolled in: ");
                String programmeName = scanner.nextLine();
                System.out.println("Enter year student is currently in: ");
                int year = scanner.nextInt();
                System.out.println("Enter semester student is currently in: ");
                int semester = scanner.nextInt();    
                          
                Programme programme = Department.findProgrammeByName(programmeName);
                Student student = new Student(studentName, studentEmail, programme, year, semester);
                Programme.addStudentToProgram(student);

                System.out.println("Student successfully created");
                break;
                break;
            case "5":
                // Add Department
                // Implement functionality here
                System.out.println("Enter department name: ");
                String departmentName = scanner.nextLine();
                System.out.println("Which faculty does this department belong to: ");
                String facultyName = scanner.nextLine();
                Faculty faculty = FacultyList.findFacultyByName(facultyName);
                Department department = new Department(departmentName, faculty);
                Faculty.addDepartments(department);

                System.out.println("Department successfully created");
                break;
            case "6":
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
                System.out.println("Type the programme name:");
                String programmeName = scanner.nextLine();
                System.out.println("Type in year when module takes place in program");
                int year = scanner.nextInt();
                System.out.println("Type in semester in which program took place:");
                int sem = scanner.nextInt();
                System.out.println("Type the module code:");
                String moduleCode = scanner.nextLine();
                System.out.println("Enter student id of student to be removed from the module:");
                int studentId = scanner.nextInt();

                ProgrammeList myProgrammeList = new ProgrammeList();
                List<Module> modulesInSem = myProgrammeList.findProgrammeByName(programmeName).getModules(year,sem);
                for(int i=0;i<modulesInSem.size();i++){
                    if(modulesInSem.get(i).getModuleCode().equals(moduleCode)){
                        //myProgrammeList.findProgrammeByName(programmeName).getModule(myProgrammeList.findProgrammeByName(programmeName).getModules(year,sem),moduleCode).removeStudentFromModule();
                        myProgrammeList.findProgrammeByName(programmeName).getModule(moduleCode).removeStudentFromModule(studentId);
                    } 
                }
                
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
