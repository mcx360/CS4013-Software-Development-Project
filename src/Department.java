
import java.util.ArrayList;
public class Department{
    private String departmentName;
    private ArrayList<Programme> departmentProgrammes;
    private ArrayList<String> departmentFaculty;

    public Department(String departmentName){
        this.departmentName = departmentName;
    }
    
    public Department(String departmentName,ArrayList<Programme> departmentProgrammes){
        this.departmentName = departmentName;
        this.departmentProgrammes = departmentProgrammes;
    }

    public Department(String departmentName,ArrayList<Programme> departmentProgrammes,ArrayList<String> departmentFaculty){
        this.departmentName = departmentName;
        this.departmentProgrammes = departmentProgrammes;
        this.departmentFaculty = departmentFaculty;
    }

    public void addProgramme(Programme programme){
        departmentProgrammes.add(programme);
    }

    public void cancelProgramme(Programme programme){
        departmentProgrammes.remove(programme);
    }

    public ArrayList<Programme> getDepartmentProgrammes(){
        return departmentProgrammes;
    }

    public void addFaculty(String name){
        departmentFaculty.add(name);
    }

    public void removeFaculty(String name){
        departmentFaculty.remove(name);
    }

}
