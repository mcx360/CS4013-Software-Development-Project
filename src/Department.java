/**
 * Department class represents a university department containg infrormation
 * about the departments names,programmes and members
 */
import java.util.ArrayList;

public class Department{
    private String departmentName;
    private ArrayList<Programme> departmentProgrammes;
    private ArrayList<String> departmentFaculty;
    private Faculty faculty;

    /**
     * 
     * @param departmentName the name of the department 
     * @param faculty the name of the associated faculty
     */
    public Department(String departmentName, Faculty faculty){
        this.departmentName = departmentName;
        this.faculty=faculty;
        departmentProgrammes = new ArrayList<>();
        departmentFaculty = new ArrayList<>();
    }
    
    /**
     * Department constructor with parameters specifying the departments name, programmes and faculty
     * 
     * @param departmentName the name of the department 
     * @param departmentProgrammes the programmes associated with the department
     * @param faculty the name of the associated faculty
     */
    public Department(String departmentName,ArrayList<Programme> departmentProgrammes,Faculty faculty){
        this.faculty = faculty;
        this.departmentName = departmentName;
        this.departmentProgrammes = departmentProgrammes;
        departmentFaculty = new ArrayList<>();
    }

    /**
     * Department constructor with parameters specifying the departments name, programmes,faculty
     * 
     * @param departmentName
     * @param departmentProgrammes
     * @param departmentFaculty
     * @param faculty
     */
    public Department(String departmentName,ArrayList<Programme> departmentProgrammes,ArrayList<String> departmentFaculty,Faculty faculty){
        this.faculty = faculty;
        this.departmentName = departmentName;
        this.departmentProgrammes = departmentProgrammes;
        this.departmentFaculty = departmentFaculty;
    }

    /**
     * 
     * @return return the departments name
     */
    public String getDepartmentName(){
        return this.departmentName;
    }

    /**
     * 
     * @return returns the departments associated faculty
     */
    public Faculty getFaculty() {
        return this.faculty;
    }

    /**
     * 
     * @param programme adds programme to the department
     */
    public void addProgramme(Programme programme){
        departmentProgrammes.add(programme);
        this.faculty.facultyList.programmeList.addProgramme(programme);
    }

    /**
     * 
     * @param programme removes the programme from the department
     */
    public void cancelProgramme(Programme programme){
        departmentProgrammes.remove(programme);
    }

    /**
     * 
     * @return returns a list of the departments available programmes
     */
    public ArrayList<Programme> getDepartmentProgrammes(){
        return departmentProgrammes;
    }

    /**
     * 
     * @param name the name of the faculty to be added
     */
    public void addFaculty(String name){
        departmentFaculty.add(name);
    }

    /**
     * 
     * @param name the name of the faculty to be removed
     */
    public void removeFaculty(String name){
        departmentFaculty.remove(name);
    }

    /**
     * returns string representation of the department object
     */
    @Override
    public String toString(){
        return "Department: "+departmentName +"\n"+departmentProgrammesToString()+"\n Deparment Programmes: \n"+departmentProgrammesToString()+"\n"+departmentFacultyToString(); 
    }

    /**
     * 
     * @return returns the departments programmes as a String
     */
    public String departmentProgrammesToString(){
        String Programmes = "";
        for(int i=0;i<departmentProgrammes.size();i++){
            Programmes+=i+1+"."+departmentProgrammes.get(i)+"\n";
        }
        return Programmes;
    }

    /**
     * 
     * @return  returns the faculty of the department in String format
     */
    public String departmentFacultyToString(){
        String departmentFacultyMembers = "Department faculty: \n";
        for(int i=0;i<departmentFaculty.size();i++){
            departmentFacultyMembers+=departmentFaculty.get(i)+"\n";
        }
        return departmentFacultyMembers+"\n";
    }

    /**
     * 
     * @param programmeName name of programme to be found
     * @return returns if programme with given name exists
     */
    public Programme findProgrammeByName(String programmeName) {
        for (Programme programme: departmentProgrammes) {
            if (programme.getProgrammeName().equals(programmeName)) {
                return programme;
            }
        }
        return null;
    }
}