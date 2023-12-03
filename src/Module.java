
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
/**
 * The Module class represents an academic module in a university.
 * It includes information about the module name, code, professor, credits, and associated students.
 * The class also manages student grades and provides methods for handling module-related operations.
 */

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

     /**
     * Constructs a new Module with the specified parameters and the default grading system for the university.
     *
     * @param moduleMapCode The code representing the module's year and semester.
     * @param moduleName    The name of the module.
     * @param moduleCode    The code of the module.
     * @param credits       The credit value of the module.
     * @param programme     The associated programme.
     * @param professor     The professor teaching the module.
     */
    //This constructor will make the module have the default grading system for the university
    public Module(int moduleMapCode,String moduleName,String moduleCode,int credits,Programme programme,String professor){
        this.moduleName =moduleName;
        this.moduleCode = moduleCode;
        this.credits = credits;
        this.studentsInModule = new ArrayList<Student>(); //By default each student in the programme is added to the module, incase a student has to be removed or a student from another programme needs to be added there are mutator methods provided
        this.moduleGradingSystem = new GradingSystem();
        this.professor = professor;
        this.year=splitInteger(moduleMapCode)[0];
        this.semester=splitInteger(moduleMapCode)[1];
        
    }

    /**
     * Constructs a new Module with the specified parameters, including the year and semester.
     *
     * @param moduleName The name of the module.
     * @param moduleCode The code of the module.
     * @param credits    The credit value of the module.
     * @param programme  The associated programme.
     * @param professor  The professor teaching the module.
     * @param year       The year in which the module is offered.
     * @param semester   The semester in which the module is offered.
     */
    public Module(String moduleName,String moduleCode,int credits,Programme programme,String professor, int year, int semester){
        this.moduleCode = moduleCode;
        this.credits = credits;
        this.studentsInModule = new ArrayList<Student>(); //By default each student in the programme is added to the module, incase a student has to be removed or a student from another programme needs to be added there are mutator methods provided
        this.moduleGradingSystem = new GradingSystem();
        this.professor = professor;
        this.year = year;
        this.semester = semester;
    }

    /**
     * Splits an integer into its tens and units place values.
     *
     * @param number The number to be split.
     * @return An array containing the tens and units place values.
     */
    public static int[] splitInteger(int number) {
        number = number % 100;

        int tens = number / 10;
        int units = number % 10;

        int[] result = { tens, units };
        return result;
    }

    /**
     * Adds a student to the module.
     *
     * @param student The student to be added.
     */
    //In the event we want to add someone outside the programme to the module, we do it using this method
    public void addStudentToModule(Student student) {
        if (!studentsInModule.contains(student)) {
            studentsInModule.add(student);
        }
    }

    /**
     * Removes a student from the module.
     *
     * @param student The student to be removed.
     */
    public void removeStudentFromModule(Student student){
        for(int i=0;i<studentsInModule.size();i++){
            if(studentsInModule.get(i).equals(student)){
                studentsInModule.remove(i);
                return;
            }
        }
    }

    /**
     * Removes a student from the module by student ID.
     *
     * @param studentId The ID of the student to be removed.
     */
    //method overloading incase we have studentId instead of student object
    public void removeStudentFromModule(int studentId){
        for(int i=0;i<studentsInModule.size();i++){
            if(studentsInModule.get(i).getID()==studentId){
                studentsInModule.remove(i);
            }
        }
    }

    /**
     * Gets the list of students in the module.
     *
     * @return The list of students in the module.
     */
    public ArrayList<Student> getStudentsInModule(){
        return studentsInModule;
    }

    /**
     * Gets the grade of a specific student in the module.
     *
     * @param student The student for whom to retrieve the grade.
     * @return The grade of the student.
     */
    public String getStudentGrade(Student student){
        return studentGrades.get(student);
    }

    /**
     * Converts a grade string to its corresponding double value.
     *
     * @param grade The grade string to be converted.
     * @return The corresponding double value for the grade.
     */
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
            default:
                return 0.0;
        }
    }

    /**
     * Gets a student in the module by student ID.
     *
     * @param studentId The ID of the student to be retrieved.
     * @return The student with the specified ID, or null if not found.
     */
    public Student getStudent(int studentId){
        for(int i=0;i<studentsInModule.size();i++){
            if(studentsInModule.get(i).getID()==studentId){
                return studentsInModule.get(i);
            }
        }
        return null;
    }

    /**
     * Gets a student in the module by ID.
     *
     * @param id The ID of the student to be retrieved.
     * @return The student with the specified ID, or null if not found.
     */
    public Student getStudentById(int id){
        for(int i=0;i<studentsInModule.size();i++){
            if(studentsInModule.get(i).getID()==id){
                return studentsInModule.get(i);
            }
        }
        return null;
    }

     /**
     * Sets the grade for a specific student in the module.
     *
     * @param student The student for whom to set the grade.
     * @param grade   The grade to be set.
     */
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

    /**
     * Gets the average grade for the module in the QCA format.
     *
     * @return The average grade for the module.
     */
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

    /**
     * Gets the credit value of the module.
     *
     * @return The credit value of the module.
     */
    public int getCredits () {
        return this.credits;
    }

    /**
     * Overrides the default toString method to provide a custom string representation of the module.
     *
     * @return A string representation of the module.
     */
    @Override
    public String toString(){
        return moduleName+"\n"+moduleCode+"\n"+"Credits: "+credits+"\n"+"Professor: "+professor+"\n";
    }

    /**
     * Gets the name of the module.
     *
     * @return The name of the module.
     */
    public String getModuleName(){
        return moduleName;
    }

    /**
     * Gets the code of the module.
     *
     * @return The code of the module.
     */
    public String getModuleCode(){
        return moduleCode;
    }

    /**
     * Gets the year in which the module is offered.
     *
     * @return The year of the module.
     */
    public int getYear(){
        return year;
    }

    /**
     * Gets the semester in which the module is offered.
     *
     * @return The semester of the module.
     */
    public int getSemester(){
        return semester;
    }

}
