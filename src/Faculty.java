import java.util.ArrayList;

public class Faculty {
    private String facultyName;
    private ArrayList<String> facultyEmailList;
    private ArrayList<Department> departments;

    public Faculty(String facultyName){
        this.facultyName = facultyName;
    }

    public Faculty(String facultyName,ArrayList<String> facultyEmailList, ArrayList<Department> departments){
        this.departments = departments;
        this.facultyEmailList = facultyEmailList;
    }

    public void addDepartments(Department department){
        departments.add(department);
    }

    public void deleteDepartment(Department department){
        departments.remove(department);
    }

    public void addFacultyEmail(String facultyEmail){
        facultyEmailList.add(facultyEmail);
    }

    public void deleteFacultyEmail(String facultyEmail){
        facultyEmailList.remove(facultyEmail);
    }

    @Override
    public String toString(){
        return facultyName
    }

    public String facultyEmailToString(){
        String facultyEmails;
        for(int i=0;i<facultyEmailList.size();i++){
            
        }
    }

}
