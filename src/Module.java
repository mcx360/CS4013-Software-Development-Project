import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
public class Module extends Programme{
    private String moduleName;
    private String moduleCode;
    private int credits;
    private ArrayList<Student> studentsInModule;
    private TreeMap<Student, String> studentGrades;
    private GradingSystem moduleGradingSystem;

    
    //This constructor will make the module have the default grading system for the university
    public Module(String moduleName,String moduleCode,int credits, Programme programme){
        super(programme);
        this.moduleName =moduleName;
        this.moduleCode = moduleCode;
        this.credits = credits;
        this.studentsInModule = getStudents(); //By default each student in the programme is added to the module, incase a student has to be removed or a student from another programme needs to be added there are mutator methods provided
        this.moduleGradingSystem = new GradingSystem();
    }

    //In the event we want to add someone outside the programme to the module, we do it using this method
    public void addStudentToModule(Student student){
        for(int i=0;i<studentsInModule.size();i++){
            if(studentsInModule.get(i).equals(student)){
                return;
            }
            studentsInModule.add(student);
        }
    }

    public void removeStudentFromModule(Student student){
        for(int i=0;i<studentsInModule.size();i++){
            if(studentsInModule.get(i).equals(student)){
                studentsInModule.remove(i);
                return;
            }
    }
    }

    public String getStudentGrade(Student student){
        return studentGrades.get(student);
    }

    //we give grade as a percentage, the program converts it into a grade
    public void setStudentGrade(Student student, int grade){
        studentGrades.put(student,moduleGradingSystem.getGrade(grade));
    }

    //we give grade as a percentage, the program converts it into a grade
    public void setStudentGrade(Student student, Double grade){
        studentGrades.put(student,moduleGradingSystem.getGrade(grade));
    }

    public char getMouduleAvg(){
        ArrayList<Double> studentResults = new ArrayList<Double>();
        for(Map.Entry<Student, String> entry : studentGrades.entrySet()){

        }
    }

}