import java.util.ArrayList;

/**
 * The Faculty class represents an academic faculty in a university.
 * It contains information about the faculty name, associated email list, departments, and a reference to the faculty list.
 */
public class Faculty {

    private String facultyName;
    private ArrayList<String> facultyEmailList;
    private ArrayList<Department> departments;
    protected FacultyList facultyList; // Reference to FacultyList

    /**
     * Constructs a new Faculty with the specified name and associated faculty list.
     *
     * @param facultyName The name of the faculty.
     * @param facultyList The faculty list associated with the faculty.
     */
    public Faculty(String facultyName, FacultyList facultyList) {
        this.facultyName = facultyName;
        this.facultyEmailList = new ArrayList<>();
        this.departments = new ArrayList<>();
        this.facultyList = facultyList;
    }

    /**
     * Adds a department to the faculty.
     *
     * @param department The department to be added.
     */
    public void addDepartments(Department department) {
        departments.add(department);
    }

    /**
     * Deletes a department from the faculty.
     *
     * @param department The department to be deleted.
     */
    public void deleteDepartment(Department department) {
        departments.remove(department);
    }

    /**
     * Adds an email to the faculty's email list.
     *
     * @param facultyEmail The email to be added.
     */
    public void addFacultyEmail(String facultyEmail) {
        facultyEmailList.add(facultyEmail);
    }

    /**
     * Deletes an email from the faculty's email list.
     *
     * @param facultyEmail The email to be deleted.
     */
    public void deleteFacultyEmail(String facultyEmail) {
        facultyEmailList.remove(facultyEmail);
    }

    /**
     * Finds a department in the faculty by its name.
     *
     * @param departmentName The name of the department to find.
     * @return The department with the specified name, or null if not found.
     */
    public Department findDepartmentByName(String departmentName) {
        for (Department department : departments) {
            if (department.getDepartmentName().equals(departmentName)) {
                return department;
            }
        }
        return null;
    }

    /**
     * Gets the name of the faculty.
     *
     * @return The name of the faculty.
     */
    public String getFacultyName() {
        return this.facultyName;
    }
}
