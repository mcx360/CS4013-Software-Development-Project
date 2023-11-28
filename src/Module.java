
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Module extends Programme{
    private String moduleName;
    private String moduleCode;
    private String professor;
    private int credits;
    private ArrayList<Student> studentsInModule;
    private TreeMap<Student, String> studentGrades;
    private TreeMap<Student, Double> studentResultInPercentage;
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

    public double getStudentGradeDouble(String grade){
        switch(grade){
            case"A1":
                return 4.0;
            case"A2":
                return 3.6;
            case"B1":
                return 3.2;
            case"B2":
                return 3.0;
            case"B3":
                return 2.8;
            case"C1":
                return 2.6;
            case"C2":
                return 2.4;
            case"C3":
                return 2.0;
            case"D1":
                return 1.6;
            case"D2":
                return 1.2;
            case"F":
                return 0.0;
            default:
                return 0.0;

        }
    }

    //we give grade as a percentage, the program converts it into a grade
    public void setStudentGrade(Student student, Double grade){
        studentGrades.put(student,moduleGradingSystem.getGrade(grade));
        studentResultInPercentage.put(student,grade);
    }

    public Double getMouduleAvg(){
        ArrayList<Double> studentResults = new ArrayList<Double>();
        for(Map.Entry<Student, Double> entry : studentResultInPercentage.entrySet()){
            studentResults.add(entry.getValue()); 
        }

        Double total = 0.0;
        for(int i=0;i<studentResults.size();i++){
            total=+studentResults.get(i);
        }
        return total/studentResults.size();
        
    }

}