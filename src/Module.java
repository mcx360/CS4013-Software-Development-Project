import java.util.ArrayList;
import java.util.Map;
public class Module extends GradingSystem{
    private int credits;
    private ArrayList<Student> studentsInModule;
    private Map<Student, Integer> studentGrades;
    private String moduleName;
    private GradingSystem moduleGradingSystem;
    
    public Module(String moduleName,int credits, ArrayList<Student> studentsInModule){
        this.moduleName=moduleName;
        this.credits = credits;
        this.studentsInModule = studentsInModule;
    }


    public char getStudentGrade(int studentId){

    }

    public void setStudentGrade(Student student){

    }

    public char getMouduleAvg(){
        
    }

}