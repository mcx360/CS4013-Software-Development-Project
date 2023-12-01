import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class ProgramInterface {
    private Scanner scanner;
    ProgrammeList listOfProgrammes = new ProgrammeList();

    private FacultyList facultyList = new FacultyList();                          
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
            System.out.println("Enter the Student Name: ");
            String studentName = scanner.nextLine();
            System.out.println("Enter the student's programme: ");
            String programmename = scanner.nextLine();
            ProgrammeList programmelist = new ProgrammeList();
           Student student =  programmelist.findProgrammeByName(programmename).findStudentByName(studentName);
           student.viewTranscript();
              //View transcript (own)
                break;
            case "2":
            System.out.println("Enter The student name :");
            String newstudentname = scanner.nextLine();
            System.out.println("Enter the student's programme: ");
            String programme = scanner.nextLine();
            ProgrammeList newprogrammelist = new ProgrammeList();
            Student studenttoGet = newprogrammelist.findProgrammeByName(programme).findStudentByName(newstudentname);
            Progression progressionstatus = new Progression(studenttoGet);
            progressionstatus.getGraduationStatus();
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
        System.out.println("1. Set Student Grade");
        System.out.println("2. View Students in Module");
        System.out.println("3. Progress Student");
        System.out.println("4. View Transcript");
        System.out.println("5. Get Module Average");
        System.out.println("6. View All Department Programmes");
        System.out.println("7. Get Average Programme QCA");
        System.out.println("8. Exam Board Options");
        System.out.println("9. Back");

        String facultyChoice = scanner.nextLine();

        switch (facultyChoice) {
            case "1":
                System.out.println("Enter programme name of the student:");
                String programmeName = scanner.nextLine();
                System.out.println("Enter module code:");
                String moduleCode = scanner.nextLine();
                System.out.println("Enter student id:");
                int studentId = scanner.nextInt();
                System.out.println("Enter student grade as a percentage:");
                Double grade = scanner.nextDouble();

                Student student = listOfProgrammes.findProgrammeByName(programmeName).getModule(moduleCode).getStudentById(studentId);
                
                listOfProgrammes.findProgrammeByName(programmeName).getModule(moduleCode).setStudentGrade(student, grade);
                break;
            case "2":
                System.out.println("Enter programme name of the module:");
                String programmeNAme = scanner.nextLine();
                System.out.println("Enter module code:");
                String moduleCOde = scanner.nextLine();
                System.out.println("Students in module:");
                ArrayList<Student> studentsInModule = listOfProgrammes.findProgrammeByName(programmeNAme).getModule(moduleCOde).getStudentsInModule();
                System.out.println("  Student name:     StudentId:");
                for(int i=0;i<studentsInModule.size();i++){
                    System.out.println(i+1+"."+studentsInModule.get(i).getName()+"\t"+studentsInModule.get(i).getID());
                }
                break;
            case "3":
                boolean graduated=false;
                System.out.println("Enter student iD to check their graduability status:");
                int id = scanner.nextInt();
                System.out.println("Enter name of programme student is enrolled in:");
                String NameOfTheProgramme = scanner.nextLine();
                ArrayList<Student> studentsInProgramme = new ArrayList<>();
                studentsInProgramme= listOfProgrammes.findProgrammeByName(NameOfTheProgramme).getStudents();
                for(int i=0;i<studentsInProgramme.size();i++){
                    if(studentsInProgramme.get(i).getID()== id){
                        Progression progress = new Progression(studentsInProgramme.get(i));
                        graduated = progress.getGraduationStatus();

                    }
                }
                System.out.println("graduated:" +graduated);
                break;
            case "4":
                // Progress Student
                // Implement functionality here
                break;
            case "5":
            Module moduleToGet;
            System.out.println("Enter the module for which you need the average for: ");
            String moduleNameToGet = scanner.nextLine();
            System.out.println("Enter the programme which this module comes under: ");
            String programmeNameToGet = scanner.nextLine();
            System.out.println("Enter the year in which this module taught: ");
            int yearToGet = scanner.nextInt();
            System.out.println("Enter the semester in which this module is taught: ");
            int semToGet = scanner.nextInt();
            ProgrammeList programmeListToGet = new ProgrammeList();
            Programme programmeToGet = programmeListToGet.findProgrammeByName(programmeNameToGet);
            for(int b=0;b<programmeToGet.getModules(yearToGet,semToGet).size();b++){
                if (programmeToGet.getModules(yearToGet,semToGet).get(b).getModuleName().equals(moduleNameToGet)){
                    moduleToGet = programmeToGet.getModules(yearToGet,semToGet).get(b);
                    moduleToGet.getMouduleAvg();
                }
            }
                break;
            case "6":
            System.out.println("Enter the department name: ");
            String departmentName = scanner.nextLine();
            System.out.println("Enter the faculty it comes under: ");
            String facultyName = scanner.nextLine();
            FacultyList listOfFaculty = new FacultyList();
            Department departmentToGet = listOfFaculty.findFacultyByName(facultyName).findDepartmentByName(departmentName);
            departmentToGet.departmentProgrammesToString();
            // View All Department Programmes
            // Implement functionality here
            break;
                break;
            case "7":
            System.out.println("Enter the Programme name: ");
            String nameOfTheProgramme = scanner.nextLine();
            ProgrammeList listOfTheProgrammes = new ProgrammeList();
            Programme programme = listOfTheProgrammes.findProgrammeByName(nameOfTheProgramme);
            programme.getAvgQCA();
             // Get Average Programme QCA
             // Implement functionality here
                break;
            case "8":
                // View All Department Programmes
                // Implement functionality here
                break;
            case "9":
                break;
            default:
                System.out.println("Invalid option for faculty.");
                break;
        }
    }

    private void uploadOptions() {
        System.out.println("Upload Options:");
        System.out.println("1. Add Students to Programme (CSV)");
        System.out.println("2. Add Module");
        System.out.println("3. Add Programme");
        System.out.println("4. Add Student to Programme");
        System.out.println("5. Add Department");
        System.out.println("6. Back");
        System.out.println("7. Add modules (csv)");

        String uploadChoice = scanner.nextLine();

        switch (uploadChoice) {
            case "1":
            System.out.println("Enter CSV file path:");
            String csvFilePath = scanner.nextLine();

            StudentCSVReader csvReader = new StudentCSVReader();
            csvReader.readStudents(csvFilePath, facultyList.programmeList);

            System.out.println("Students added from CSV successfully.");
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

                Programme moduleProgramme = facultyList.programmeList.findProgrammeByName(programmeName);

                Module module = new Module(moduleName, moduleCode, moduleCredits, moduleProgramme, professorName, year, semester);
                moduleProgramme.addModule(year, semester, module);

                System.out.println("Module successfully created");
                break;
            case "3":
                // Add Programme
                // Implement functionality here
                System.out.println("Enter Programme name: ");
                String programmeNameToAdd = scanner.nextLine();
                System.out.println("Enter programme duration: ");
                int duration = scanner.nextInt();
                System.out.println("Enter Programme level:");
                int programmeLevel = scanner.nextInt();
                scanner.nextLine();
                
                System.out.println("Which department does this programme belong to: ");
                String departmentNameOfProgramme = scanner.nextLine();

                
                System.out.println("Which faculty does this programme belong to: ");
                String facultyNameOfProgramme = scanner.nextLine();
                Faculty faculty = facultyList.findFacultyByName(facultyNameOfProgramme);

                Department departmentOfProgramme = faculty.findDepartmentByName(departmentNameOfProgramme);
                Programme programmeToAdd = new Programme(programmeNameToAdd,duration,programmeLevel, departmentOfProgramme);
                departmentOfProgramme.addProgramme(programmeToAdd);

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
                String programmeNameOfStudent = scanner.nextLine();
                System.out.println("Enter year student is currently in: ");
                int yearOfStudent = scanner.nextInt();
                System.out.println("Enter semester student is currently in: ");
                int semesterOfStudent = scanner.nextInt();    

                Programme programmeOfStudent = facultyList.programmeList.findProgrammeByName(programmeNameOfStudent);
                Student student = new Student(studentName, studentEmail, programmeOfStudent, yearOfStudent, semesterOfStudent);
                programmeOfStudent.addStudentToProgram(student);

                System.out.println("Student successfully created");
                break;
            case "5":
                // Add Department
                // Implement functionality here
                System.out.println("Enter department name: ");
                String departmentNameToAdd = scanner.nextLine();
                System.out.println("Which faculty does this department belong to: ");
                String facultyNameOfDepartmentString = scanner.nextLine();

                Faculty facultyNameOfDepartment = facultyList.findFacultyByName(facultyNameOfDepartmentString);
                Department departmentToAdd = new Department(departmentNameToAdd, facultyNameOfDepartment);
                facultyNameOfDepartment.addDepartments(departmentToAdd);

                System.out.println("Department successfully created");
                break;
            case "6":
                break;
            case "7":
                // Add Modules (CSV)
                // Implement functionality here
                System.out.println("Enter CSV file path for modules:");
                String moduleCSVFilePath = scanner.nextLine();

                System.out.println("Enter the programme name for these modules:");
                String programmeNameForModules = scanner.nextLine();

                Programme programmeForModules = facultyList.programmeList.findProgrammeByName(programmeNameForModules);

                ModuleCSVReader moduleCSVReader = new ModuleCSVReader();
                ArrayList<Module> modulesToAdd = moduleCSVReader.readModulesFromCSV(moduleCSVFilePath, programmeForModules);

                // Adding modules to the programme
                if (modulesToAdd != null && !modulesToAdd.isEmpty()) {
                    for (Module CSVmodule : modulesToAdd) {
                        programmeForModules.addModule(CSVmodule.getYear(), CSVmodule.getSemester(), CSVmodule);
                    }
                    System.out.println("Modules added from CSV successfully.");
                } else {
                    System.out.println("No modules were added. Please check the CSV file.");
                }
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

                        myProgrammeList.findProgrammeByName(programmeName).removeModule(year, sem, modulesInSem.get(i));
                    }
                }
                break;
            case "2":
            System.out.println("Enter the programme in which this module is in: ");
            String nameOfprogramme = scanner.nextLine();
            System.out.println("Enter the year when module takes place in the programme: ");
            int yearOfmodule = scanner.nextInt();
            System.out.println("Enter the semester in which the module takes place: ");
            int semesterOfmodule =  scanner.nextInt();
            System.out.println("Enter the module code: ");
            String codeOfmodule  = scanner.nextLine();

            ProgrammeList newprogrammeList = new ProgrammeList();
            List<Module> modulesinSEMESTER = newprogrammeList.findProgrammeByName(nameOfprogramme).getModules(yearOfmodule,semesterOfmodule);

            for(int s=0;s<modulesinSEMESTER.size();s++){
                if(modulesinSEMESTER.get(s).getModuleCode().equals(codeOfmodule));
                newprogrammeList.findProgrammeByName(nameOfprogramme).removeModule(yearOfmodule, semesterOfmodule,modulesinSEMESTER.get(s) );
            }
                // Remove Module
                // Implement functionality here
                break;
            case "3":
            System.out.println("Enter student's name to be removed: ");
            String studentName = scanner.nextLine();
            System.out.println("Enter the programme from which this student should be removed: ");
            String newProgrammeName = scanner.nextLine();
            ProgrammeList listOfTheprogrammes = new ProgrammeList();

            FacultyList facultyList = FacultyList.getInstance(); // assuming you have this instance in your class

            ProgrammeList listOfProgrammes = facultyList.programmeList;
            Programme programOfStudent = listOfProgrammes.findProgrammeByName(newProgrammeName);

            // Check if the program is found before attempting to find the student
            Student studentToBeRemoved = programOfStudent.findStudentByName(studentName);

            listOfTheprogrammes.findProgrammeByName(newProgrammeName).removeStudentFromProgram(studentToBeRemoved);
               // Remove Student from Programme
               // Implement functionality here
                break;
            case "4":
            System.out.println("Enter programme name: ");
            String programmeToBeRemoved = scanner.nextLine();
            ProgrammeList listOfprogrammes = new ProgrammeList();
            Programme removalProgram = listOfprogrammes.findProgrammeByName(programmeToBeRemoved);
            listOfprogrammes.removeProgramme(removalProgram);
                // Remove Programme
                // Implement functionality here
                break;
            case "5":
            System.out.println("Enter name of the faculty in which this department comes under: ");
            String facultyName = scanner.nextLine();
            System.out.println("Enter the name of department to be removed: ");
            String nameOfDepartment = scanner.nextLine();
            FacultyList listOffaculties = new FacultyList();
            Faculty nameOffaculty = listOffaculties.findFacultyByName(facultyName);
            Department department = nameOffaculty.findDepartmentByName(nameOfDepartment) ;
            nameOffaculty.deleteDepartment(department);


            

                // Remove Department
                // Implement functionality here
                break;
            case "6":
            System.out.println("Enter name of the faculty to be removed: ");
            String NameOfFaculty = scanner.nextLine();
            FacultyList newListOfFaculties = new FacultyList();
            Faculty facultyTobeRemoved = newListOfFaculties.findFacultyByName(NameOfFaculty);
            newListOfFaculties.removeFaculty(facultyTobeRemoved);

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