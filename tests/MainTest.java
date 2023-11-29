import java.util.ArrayList;
public class MainTest {
    public static void main(String[] args){
        Faculty ScienceAndEngineering = new Faculty("ScienceAndEngineering");
        Department CSIS = new Department("ComputerScience&InformationSystems");
        Programme ComputerScience = new Programme("ComputerScience", 4, 8);
        

        
        Student Oscar = new Student("Oscar Zhou", "22338705@studentmail.ul.ie", ComputerScience, 2, 1);
        Student Michal = new Student("Michal", "22361979@studentmail.ul.ie", ComputerScience, 2, 1);
        Student Vivian = new Student("Vivian", "123@gmail.com", ComputerScience, 2, 1);
        
        ComputerScience.addStudentToProgram(Vivian);
        ComputerScience.addStudentToProgram(Oscar);
        ComputerScience.addStudentToProgram(Michal);

        Module CS4013 = new Module("Object-Oriented-Development","CS4013",6,ComputerScience,"Michael English");
        Module CS4004 = new Module("Software Testing", "CS4004", 6, ComputerScience, "Faeq Alrimawi");
        Module CS4023 = new Module("Os","CS4023",6,ComputerScience,"Abdul Razzaq");
       
        ComputerScience.addModule(2, 1, CS4013);
        //ComputerScience.removeModule(2,1,CS4013);

        CS4013.addStudentToModule(Vivian);
        CS4013.addStudentToModule(Oscar);
        CS4013.setStudentGrade(Vivian, 50.0);
        CS4013.setStudentGrade(Oscar, 100.00);
        CS4013.removeStudentFromModule(Vivian);

        CS4013.getMouduleAvg();
        CSIS.addProgramme(ComputerScience);
        ScienceAndEngineering.addDepartments(CSIS);
        ScienceAndEngineering.deleteDepartment(CSIS);



    }
}
