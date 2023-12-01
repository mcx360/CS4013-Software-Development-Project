import java.util.ArrayList;

public class Faculty {
    private String facultyName;
    private ArrayList<String> facultyEmailList;
    private ArrayList<Department> departments;
    protected FacultyList facultyList; // Reference to FacultyList

    public Faculty(String facultyName,  FacultyList facultyList) {
        this.facultyName = facultyName;
        this.facultyEmailList = new ArrayList<>();
        this.departments = new ArrayList<>();
        this.facultyList=facultyList;
    }

    public void addDepartments(Department department) {
        departments.add(department);
    }

    public void deleteDepartment(Department department) {
        departments.remove(department);
    }

    public void addFacultyEmail(String facultyEmail){
        facultyEmailList.add(facultyEmail);
    }

    public void deleteFacultyEmail(String facultyEmail){
        facultyEmailList.remove(facultyEmail);
    }

    public Department findDepartmentByName(String DepartmentName) {
        for (Department department : departments) {
            if (department.getDepartmentName().equals(DepartmentName)) {
                return department;
            }
        }
        return null;
    }

    public String getFacultyName() {
        return this.facultyName;
    }
}