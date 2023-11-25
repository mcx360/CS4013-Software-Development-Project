import java.util.ArrayList;

public interface Results {
    public String getStudentResult(Student student);
    public ArrayList<String> getModuleResults(Module module);
    public ArrayList<String> getProgrammeResults(Programme programme);
}
