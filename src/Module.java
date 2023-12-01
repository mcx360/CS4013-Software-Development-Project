
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Module{
    private int year,semester;
    private String moduleName;
    private String moduleCode;
    private String professor;
    private int credits;
    private ArrayList<Student> studentsInModule;
    private TreeMap<Student, String> studentGrades = new TreeMap<>();
    private GradingSystem moduleGradingSystem;
    private boolean pass;
    private boolean compensatingFail;

    
    //This constructor will make the module have the default grading system for the university
    public Module(int moduleMapCode,String moduleName,String moduleCode,int credits,Programme programme,String professor){
        this.moduleName =moduleName;
        this.moduleCode = moduleCode;
        this.credits = credits;
        this.studentsInModule = programme.getStudents(); //By default each student in the programme is added to the module, incase a student has to be removed or a student from another programme needs to be added there are mutator methods provided
        this.moduleGradingSystem = new GradingSystem();
        this.professor = professor;
        this.year=splitInteger(moduleMapCode)[0];
        this.semester=splitInteger(moduleMapCode)[1];
        
    }

    public Module(String moduleName,String moduleCode,int credits,Programme programme,String professor, int year, int semester){
        this.moduleCode = moduleCode;
        this.credits = credits;
        this.studentsInModule = programme.getStudents(); //By default each student in the programme is added to the module, incase a student has to be removed or a student from another programme needs to be added there are mutator methods provided
        this.moduleGradingSystem = new GradingSystem();
        this.professor = professor;
        this.year = year;
        this.semester = semester;
    }

    public static int[] splitInteger(int number) {
        number = number % 100;

        int tens = number / 10;
        int units = number % 10;

        int[] result = { tens, units };
        return result;
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

    public void removeStudentFromModule(int studentId){
        for(int i=0;i<studentsInModule.size();i++){
            if(studentsInModule.get(i).getID()==studentId){
                studentsInModule.remove(i);
            }
        }
    }

    public ArrayList<Student> getStudentsInModule(){
        return studentsInModule;
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

    public Student getStudent(int studentId){
        for(int i=0;i<studentsInModule.size();i++){
            if(studentsInModule.get(i).getID()==studentId){
                return studentsInModule.get(i);
            }
        }
        return null;
    }

    //we give grade as a percentage, the program converts it into a grade
    public void setStudentGrade(Student student, Double grade){
        studentGrades.put(student,GradingSystem.getGrade(grade));
        if(getStudentGrade(student)=="NG"){
            this.pass=false;
            this.compensatingFail=false;
        }
        else if(getStudentGrade(student)=="F"){
            this.pass=false;
            this.compensatingFail=false;
        }
        else if(getStudentGrade(student)=="D1"){
            this.pass = false;
            this.compensatingFail = true;
        }
        else if(getStudentGrade(student)=="D2"){
            this.pass = false;
            this.compensatingFail = true;
        }
        else{
            this.pass = true;
            this.compensatingFail = false;
        }
    }

    //returns average for moudule in the qca format e.g average=2.8
    public Double getMouduleAvg(){
        ArrayList<Double> studentResults = new ArrayList<Double>();
        for(Map.Entry<Student, String> entry : studentGrades.entrySet()){
            studentResults.add(getStudentGradeDouble(entry.getValue())); 
        }

        Double total = 0.0;
        for(int i=0;i<studentResults.size();i++){
            total+=studentResults.get(i);
        }
        return total/studentResults.size();
    }

    public int getCredits () {
        return this.credits;
    }

    @Override
    public String toString(){
        return moduleName+"\n"+moduleCode+"\n"+"Credits: "+credits+"\n"+"Professor: "+professor+"\n";
    }

    public String getModuleName(){
        return moduleName;
    }

    public String getModuleCode(){
        return moduleCode;
    }

    public Student getStudentById(int id){
        for(int i=0;i<studentsInModule.size();i++){
            if(studentsInModule.get(i).getID()==id){
                return studentsInModule.get(i);
            }
        }
        return null;
    }

    

    
    
}