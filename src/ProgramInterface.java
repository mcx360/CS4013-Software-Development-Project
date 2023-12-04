import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import ExamBoard.ExamBoardMenu;

public class ProgramInterface {
    private Scanner scanner;
    private FacultyList facultyList = new FacultyList(); 
    ExamBoardMenu menu = new ExamBoardMenu();
                             
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
        scanner.nextLine();
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
            //ProgrammeList programmelist = new ProgrammeList();
            Student student = facultyList.programmeList.findProgrammeByName(programmename).findStudentByName(studentName);
            String a = student.viewTranscript();
            System.out.println(a);
              //View transcript (own)
                break;
            case "2":
            System.out.println("Enter The student name :");
            String newstudentname = scanner.nextLine();
            System.out.println("Enter the student's programme: ");
            String programme = scanner.nextLine();
            //ProgrammeList newprogrammelist = new ProgrammeList();
            Student studenttoGet = facultyList.programmeList.findProgrammeByName(programme).findStudentByName(newstudentname);
            Progression progressionstatus = new Progression(studenttoGet);
            if (progressionstatus.getGraduationStatus() == true) {
            	System.out.println("Student is eligible to graduate");
            } else {
            	System.out.println("Student is not eligible to graduate");
            }
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

        try {
        switch (facultyChoice) {
            case "1":
                System.out.println("Enter programme name:");
                String programmeName = scanner.nextLine();
                System.out.println("Enter module code:");
                String moduleCode = scanner.nextLine();
                System.out.println("Enter student id:");
                int studentId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter student grade as a percentage:");
                Double grade = scanner.nextDouble();
                scanner.nextLine();

                Programme programmeofStudent = facultyList.programmeList.findProgrammeByName(programmeName);
                Student student = programmeofStudent.getModule(moduleCode).getStudentById(studentId);
                
                facultyList.programmeList.findProgrammeByName(programmeName).getModule(moduleCode).setStudentGrade(student, grade);
                System.out.println("Student grade set");
                break;
            case "2":
                System.out.println("Enter programme name: ");
                String programmeNAme = scanner.nextLine();
                System.out.println("Enter module code: ");
                String moduleCOde = scanner.nextLine();
                System.out.println("Students in module: ");
                
                Programme programmeOfStudent = facultyList.programmeList.findProgrammeByName(programmeNAme);
                ArrayList<Student> studentsInModule = programmeOfStudent.getModule(moduleCOde).getStudentsInModule();
                
                System.out.println("  Student name:     StudentId:");
                for(int i=0;i<studentsInModule.size();i++){
                    System.out.println(i+1+"."+studentsInModule.get(i).getName()+"\t"+studentsInModule.get(i).getID());
                }
                break;
            case "3":
                System.out.println("Enter student iD: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter name of programme student is enrolled in: ");
                String NameOfTheProgramme = scanner.nextLine();
                ArrayList<Student> studentsInProgramme = new ArrayList<>();
                studentsInProgramme= facultyList.programmeList.findProgrammeByName(NameOfTheProgramme).getStudents();
                for(int i=0;i<studentsInProgramme.size();i++){
                    if(studentsInProgramme.get(i).getID()== id){
                        Progression progress = new Progression(studentsInProgramme.get(i));
                        System.out.println("Student has " + progress.progressStudent()); 
                    }
                }
                break;
            case "4":
                System.out.println("Enter id of student which you want to see the transcript of: ");
                int idOfStudent = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the programme in which the student is enrolled in: ");
                String PROGRAMME = scanner.nextLine();
                ArrayList<Student> listOfStudents = facultyList.programmeList.findProgrammeByName(PROGRAMME).getStudents();
                for(int i=0;i<listOfStudents.size();i++){
                    if(listOfStudents.get(i).getID()==idOfStudent){
                        System.out.println(listOfStudents.get(i).viewTranscript());
                    }
                }
                break;
            case "5":
            Module moduleToGet;
            System.out.println("Enter the module code for which you need the average for: ");
            String moduleNameToGet = scanner.nextLine();
            System.out.println("Enter the programme which this module comes under: ");
            String programmeNameToGet = scanner.nextLine();

            //ProgrammeList programmeListToGet = new ProgrammeList();
            Programme programmeToGet = facultyList.programmeList.findProgrammeByName(programmeNameToGet);
            Module module = programmeToGet.getModule(moduleNameToGet);
            System.out.println("The avaerage QCA is: " + module.getMouduleAvg());
                break;
            case "6":
            System.out.println("Enter the department name: ");
            String departmentName = scanner.nextLine();
            System.out.println("Enter the faculty it comes under: ");
            String facultyName = scanner.nextLine();
            //FacultyList listOfFaculty = new FacultyList();
            Department departmentToGet = facultyList.findFacultyByName(facultyName).findDepartmentByName(departmentName);
            System.out.println(departmentToGet.departmentProgrammesToString()); 
            // View All Department Programmes
            // Implement functionality here
            break;
            case "7":
            System.out.println("Enter the Programme name: ");
            String nameOfTheProgramme = scanner.nextLine();
            //ProgrammeList listOfTheProgrammes = new ProgrammeList();
            Programme programme = facultyList.programmeList.findProgrammeByName(nameOfTheProgramme);
            System.out.println("The average QCA is: " + programme.getAvgQCA()); 
                break;
            case "8":
                	//ExamBoardMenu menu = new ExamBoardMenu();
                    menu.run();

                break;
            case "9":
                break;
            default:
                System.out.println("Invalid option for faculty.");
                break;
        }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
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

        try {
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
                scanner.nextLine();
                System.out.println("Enter professor name: ");
                String professorName = scanner.nextLine();
                System.out.println("Which year is this module taken at: ");
                int year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Which semester is this module taken at: ");
                int semester = scanner.nextInt();
                scanner.nextLine();
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
                scanner.nextLine();
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
                scanner.nextLine();
                System.out.println("Enter semester student is currently in: ");
                int semesterOfStudent = scanner.nextInt();   
                scanner.nextLine();

                Programme programmeOfStudent = facultyList.programmeList.findProgrammeByName(programmeNameOfStudent);
                Student student = new Student(studentName, studentEmail, programmeOfStudent, yearOfStudent, semesterOfStudent);
                programmeOfStudent.addStudentToProgram(student);
                
                for (Map.Entry<Map.Entry<Integer, Integer>, ArrayList<Module>> entry : programmeOfStudent.moduleMap.entrySet()) {
                    Map.Entry<Integer, Integer> moduleKey = entry.getKey();
                    int moduleYear = moduleKey.getKey();
                    int moduleSemester = moduleKey.getValue();

                    if (student.getYear() == moduleYear && student.getSemester() == moduleSemester) {
                        ArrayList<Module> modules = entry.getValue();
                        
                        // Iterate through each module in this specific year and semester
                        for (Module moduleAdd : modules) {
                            moduleAdd.addStudentToModule(student);
                        }
                    }
                }


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
    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
    }

    private void removeOptions() {
        System.out.println("Remove Options:");
        System.out.println("1. Remove Student from Module");
        System.out.println("2. Remove Module");
        System.out.println("3. Remove Student from Programme");
        System.out.println("4. Remove Programme");
        System.out.println("5. Remove Department");
        System.out.println("6. Back");

        String removeChoice = scanner.nextLine();

        try {
        switch (removeChoice) {
            case "1":
                   // Remove Student from Module
                // Implement functionality here
                System.out.println("Type the programme name:");
                String programmeName = scanner.nextLine();
                System.out.println("Type in year when module takes place in program");
                int year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Type in semester in which program took place:");
                int sem = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Type the module code:");
                String moduleCode = scanner.nextLine();
                System.out.println("Enter student id of student to be removed from the module:");
                int studentId = scanner.nextInt();
                scanner.nextLine();
                //ProgrammeList myProgrammeList = new ProgrammeList();
                List<Module> modulesInSem = facultyList.programmeList.findProgrammeByName(programmeName).getModules(year,sem);
                for(int i=0;i<modulesInSem.size();i++){
                    if(modulesInSem.get(i).getModuleCode().equals(moduleCode)){

                        facultyList.programmeList.findProgrammeByName(programmeName).getModule(moduleCode).removeStudentFromModule(studentId);
                    }
                }
                break;
            case "2":
            System.out.println("Enter the programme in which this module is in: ");
            String nameOfprogramme = scanner.nextLine();
            System.out.println("Enter the year when module takes place in the programme: ");
            int yearOfmodule = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the semester in which the module takes place: ");
            int semesterOfmodule =  scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the module code: ");
            String codeOfmodule  = scanner.nextLine();

            //ProgrammeList newprogrammeList = new ProgrammeList();
            List<Module> modulesinSEMESTER = facultyList.programmeList.findProgrammeByName(nameOfprogramme).getModules(yearOfmodule,semesterOfmodule);

            for(int s=0;s<modulesinSEMESTER.size();s++){
                if(modulesinSEMESTER.get(s).getModuleCode().equals(codeOfmodule));
                facultyList.programmeList.findProgrammeByName(nameOfprogramme).removeModule(yearOfmodule, semesterOfmodule,modulesinSEMESTER.get(s) );
            }
                // Remove Module
                // Implement functionality here
                break;
            case "3":
            System.out.println("Enter student's name to be removed: ");
            String studentName = scanner.nextLine();
            System.out.println("Enter the programme from which this student should be removed: ");
            String newProgrammeName = scanner.nextLine();
            //ProgrammeList listOfTheprogrammes = new ProgrammeList();

            //FacultyList facultyList = FacultyList.getInstance(); // assuming you have this instance in your class

            //ProgrammeList listOfProgrammes = facultyList.programmeList;
            Programme programOfStudent = facultyList.programmeList.findProgrammeByName(newProgrammeName);

            // Check if the program is found before attempting to find the student
            Student studentToBeRemoved = programOfStudent.findStudentByName(studentName);

            facultyList.programmeList.findProgrammeByName(newProgrammeName).removeStudentFromProgram(studentToBeRemoved);
               // Remove Student from Programme
               // Implement functionality here
                break;
            case "4":
            System.out.println("Enter programme name: ");
            String programmeToBeRemoved = scanner.nextLine();
            Programme removalProgram = facultyList.programmeList.findProgrammeByName(programmeToBeRemoved);
            facultyList.programmeList.removeProgramme(removalProgram);
                // Remove Programme
                // Implement functionality here
                break;
            case "5":
            System.out.println("Enter name of the faculty in which this department comes under: ");
            String facultyName = scanner.nextLine();
            System.out.println("Enter the name of department to be removed: ");
            String nameOfDepartment = scanner.nextLine();
            //FacultyList listOffaculties = new FacultyList();
            Faculty nameOffaculty = facultyList.findFacultyByName(facultyName);
            Department department = nameOffaculty.findDepartmentByName(nameOfDepartment) ;
            nameOffaculty.deleteDepartment(department);


            

                // Remove Department
                // Implement functionality here
                break;
            case "6":
                break;
            default:
                System.out.println("Invalid option for remove.");
                break;
        }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

}
