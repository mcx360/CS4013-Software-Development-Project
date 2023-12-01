import java.util.ArrayList;
import java.util.List;

class FacultyList {
    private static FacultyList instance = null;
    private List<Faculty> faculties;
    protected ProgrammeList programmeList;

    public FacultyList() {
        faculties = new ArrayList<>();
        Faculty arts = new Faculty("Faculty of Arts, Humanities, and Social Sciences",this);
        Faculty educ = new Faculty("Faculty of Education and Health Science",this);
        Faculty busi = new Faculty("Kemmy Business School",this);
        Faculty scie = new Faculty("Faculty of Science And Engineering",this);
        Faculty worl = new Faculty("Irish World Academy of Music & Dance",this);
        
        faculties.add(arts);
        faculties.add(educ);
        faculties.add(busi);
        faculties.add(scie);
        faculties.add(worl);

        programmeList = new ProgrammeList();
        
        
    }

    public static FacultyList getInstance() {
        if (instance == null) {
            instance = new FacultyList();
        }
        return instance;
    }
    
    public List<Faculty> getFaculties() {
        return faculties;
    }

    public Faculty findFacultyByName(String facultyName) {
        for (Faculty faculty : faculties) {
            if (faculty.getFacultyName().equals(facultyName)) {
                return faculty;
            }
        }
        return null;
    }

    public void removeFaculty (Faculty faculty){
        faculties.remove(faculty);
    }
}