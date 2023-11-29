
import java.util.ArrayList;
public class Department{
    private String departmentName;
    private ArrayList<Programme> departmentProgrammes;
    private ArrayList<String> departmentFaculty;

    public Department(String departmentName){
        this.departmentName = departmentName;
        departmentProgrammes = new ArrayList<>();
        departmentFaculty = new ArrayList<>();
    }
    
    public Department(String departmentName,ArrayList<Programme> departmentProgrammes){
        this.departmentName = departmentName;
        this.departmentProgrammes = departmentProgrammes;
        departmentProgrammes = new ArrayList<>();
        departmentFaculty = new ArrayList<>();
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

    @Override
    public String toString(){
        return "Department: "+departmentName +"\n"+departmentProgrammesToString(); 
    }

    public String departmentProgrammesToString(){
        String Programmes = "";
        for(int i=0;i<departmentProgrammes.size();i++){
            Programmes+=i+1+"."+departmentProgrammes.get(i)+"\n";
        }
        return Programmes;
    }

    public String departmentFacultyToString(){
        String departmentFacultyMembers = "Department faculty: \n";
        for(int i=0;i<departmentFaculty.size();i++){
            departmentFacultyMembers+=departmentFaculty.get(i)+"\n";
        }
        return departmentFacultyMembers+"\n";
    }

    

}
