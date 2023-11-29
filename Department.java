import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Programme> programmes;

    public Department() {
        programmes = new ArrayList<>();
    }

    public void addProgramme(Programme programme) {
        programmes.add(programme);
    }

    public void removeProgramme(Programme programme) {
        programmes.remove(programme);
    }

    public Programme findProgrammeByName(String programmeName) {
        for (Programme programme : programmes) {
            if (programme.getProgrammeName().equals(programmeName)) {
                return programme;
            }
        }
        return null;
    }

    public List<Programme> getAllProgrammes() {
        return programmes;
    }
}
