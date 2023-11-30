import java.util.List;
import java.util.ArrayList;

class FacultyList{
    private List<Faculty> faculty;

    public FacultyList() {
        faculty = new ArrayList<Faculty>();
        Faculty arts = new Faculty("Faculty of Arts, Humanities, and Social Sciences");
        Faculty educ = new Faculty("Faculty of Education and Health Science");
        Faculty busi = new Faculty("Kemmy Business School");
        Faculty scie = new Faculty("Faculty of Science And Engineering");
        Faculty worl = new Faculty("Irish World Academy of Music & Dance");
        faculty.add(arts);
        faculty.add(educ);
        faculty.add(busi);
        faculty.add(scie);
        faculty.add(worl);
    }

    public Faculty findFacultyByName(String facultyName) {
        for (Faculty faculty : faculty) {
            if (faculty.getFacultyName().equals(facultyName)) {
                return faculty;
            }
        }
        return null;
    }
}