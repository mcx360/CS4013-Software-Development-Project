import java.util.ArrayList;
import java.util.List;

/**
 * The FacultyList class represents a collection of faculties in a university.
 * It is designed as a singleton class to manage and provide access to the list of faculties.
 */
class FacultyList {

    private static FacultyList instance = null;
    private List<Faculty> faculties;
    protected ProgrammeList programmeList;

    /**
     * Constructs a new FacultyList and initializes it with predefined faculties.
     */
    public FacultyList() {
        faculties = new ArrayList<>();
        Faculty arts = new Faculty("Faculty of Arts, Humanities, and Social Sciences", this);
        Faculty educ = new Faculty("Faculty of Education and Health Science", this);
        Faculty busi = new Faculty("Kemmy Business School", this);
        Faculty scie = new Faculty("Faculty of Science And Engineering", this);
        Faculty worl = new Faculty("Irish World Academy of Music & Dance", this);

        faculties.add(arts);
        faculties.add(educ);
        faculties.add(busi);
        faculties.add(scie);
        faculties.add(worl);

        programmeList = new ProgrammeList();
    }

    /**
     * Gets the singleton instance of the FacultyList.
     *
     * @return The singleton instance of the FacultyList.
     */
    public static FacultyList getInstance() {
        if (instance == null) {
            instance = new FacultyList();
        }
        return instance;
    }

    /**
     * Gets the list of faculties in the FacultyList.
     *
     * @return The list of faculties.
     */
    public List<Faculty> getFaculties() {
        return faculties;
    }

    /**
     * Finds a faculty in the FacultyList by its name.
     *
     * @param facultyName The name of the faculty to find.
     * @return The faculty with the specified name, or null if not found.
     */
    public Faculty findFacultyByName(String facultyName) {
        for (Faculty faculty : faculties) {
            if (faculty.getFacultyName().equals(facultyName)) {
                return faculty;
            }
        }
        return null;
    }

    /**
     * Removes a faculty from the FacultyList.
     *
     * @param faculty The faculty to be removed.
     */
    public void removeFaculty(Faculty faculty) {
        faculties.remove(faculty);
    }
}
