import java.util.ArrayList;
import java.util.List;

/**
 * The `ProgrammeList` class represents a list of academic programs. It provides methods to add, remove, find, and retrieve
 * information about programs stored in the list.
 */
public class ProgrammeList {

    private List<Programme> programmes;

    /**
     * Constructs a new `ProgrammeList` with an empty list of programs.
     */
    public ProgrammeList() {
        programmes = new ArrayList<>();
    }

    /**
     * Adds a new academic program to the list.
     *
     * @param programme The program to add to the list.
     */
    public void addProgramme(Programme programme) {
        programmes.add(programme);
    }

    /**
     * Removes an academic program from the list.
     *
     * @param programme The program to remove from the list.
     */
    public void removeProgramme(Programme programme) {
        programmes.remove(programme);
    }

    /**
     * Finds an academic program in the list based on its name.
     *
     * @param programmeName The name of the program to find.
     * @return The program with the specified name, or null if not found.
     */
    public Programme findProgrammeByName(String programmeName) {
        for (Programme programme : programmes) {
            if (programme.getProgrammeName().equals(programmeName)) {
                return programme;
            }
        }
        return null;
    }

    /**
     * Retrieves a list of all academic programs in the `ProgrammeList`.
     *
     * @return A list of all academic programs in the `ProgrammeList`.
     */
    public List<Programme> getAllProgrammes() {
        return programmes;
    }
}
