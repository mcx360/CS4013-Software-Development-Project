import java.util.ArrayList;
import java.util.List;

class FacultyList {
    private List<Faculty> faculties;
    protected ProgrammeList programmeList;

    public FacultyList() {
        faculties = new ArrayList<>();
        Faculty arts = new Faculty("Faculty of Arts, Humanities, and Social Sciences");
        Faculty educ = new Faculty("Faculty of Education and Health Science");
        Faculty busi = new Faculty("Kemmy Business School");
        Faculty scie = new Faculty("Faculty of Science And Engineering");
        Faculty worl = new Faculty("Irish World Academy of Music & Dance");
        
        faculties.add(arts);
        faculties.add(educ);
        faculties.add(busi);
        faculties.add(scie);
        faculties.add(worl);

        programmeList = new ProgrammeList();
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
