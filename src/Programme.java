import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The `Programme` class represents an academic program within a department. It contains information such as program name,
 * duration, level, program ID, a list of students enrolled, a map of modules organized by year and semester, and the
 * department to which it belongs.
 */
public class Programme {

    private String ProgrammeName;
    private int Duration;
    private int ProgrammeLevel;
    private int ProgrammeID;
    private ArrayList<Student> Students;
    protected Map<Map.Entry<Integer, Integer>, ArrayList<Module>> moduleMap;
    private Department department;

    /**
     * Constructs a new `Programme` with the specified details.
     *
     * @param ProgrammeName The name of the program.
     * @param Duration      The duration of the program in years.
     * @param ProgrammeLevel The level of the program.
     * @param department    The department to which the program belongs.
     */
    public Programme(String ProgrammeName, int Duration, int ProgrammeLevel, Department department) {
        this.department = department;
        this.ProgrammeName = ProgrammeName;
        this.ProgrammeLevel = ProgrammeLevel;
        this.Duration = Duration;
        this.Students = new ArrayList<>();
        this.moduleMap = new HashMap<>();
    }

    /**
     * Calculates and returns the average Quality Credit Average (QCA) of all students in the program.
     *
     * @return The average QCA of all students in the program.
     */
    public double getAvgQCA() {
        double result = 0;
        for (int i = 0; i < Students.size(); i++) {
            Student x = Students.get(i);
            result += x.calculateTotalAverageQCA(x);
        }
        return result / Students.size();
    }

    /**
     * Retrieves a module based on its module code.
     *
     * @param moduleCode The code of the module to retrieve.
     * @return The module with the specified code, or null if not found.
     */
    public Module getModule(String moduleCode) {
        for (ArrayList<Module> modules : moduleMap.values()) {
            for (Module module : modules) {
                if (module.getModuleCode().equals(moduleCode)) {
                    return module;
                }
            }
        }
        return null;
    }

    /**
     * Retrieves a list of modules for a specific year and semester.
     *
     * @param year     The year of the modules.
     * @param semester The semester of the modules.
     * @return A list of modules for the specified year and semester, or an empty list if not found.
     */
    public List<Module> getModules(int year, int semester) {
        List<Module> empty = new ArrayList<>();
        Map.Entry<Integer, Integer> key = Map.entry(year, semester);
        if (moduleMap.containsKey(key)) {
            return moduleMap.get(key);
        }
        return empty;
    }

    /**
     * Retrieves a list of all modules in the program.
     *
     * @return A list of all modules in the program.
     */
    public List<Module> getModules() {
        List<Module> allModules = new ArrayList<>();

        // Iterate through the values of the moduleMap
        for (ArrayList<Module> moduleList : moduleMap.values()) {
            allModules.addAll(moduleList);
        }

        return allModules;
    }

    /**
     * Adds a module to the program for a specific year and semester.
     *
     * @param year    The year of the module.
     * @param semester The semester of the module.
     * @param module  The module to add.
     */
    public void addModule(int year, int semester, Module module) {
        Map.Entry<Integer, Integer> key = Map.entry(year, semester);
        this.moduleMap.computeIfAbsent(key, k -> new ArrayList<>()).add(module);
    }

    /**
     * Removes a module from the program for a specific year and semester.
     *
     * @param year    The year of the module.
     * @param semester The semester of the module.
     * @param module  The module to remove.
     */
    public void removeModule(int year, int semester, Module module) {
        Map.Entry<Integer, Integer> key = Map.entry(year, semester);
        moduleMap.computeIfPresent(key, (k, modules) -> {
            modules.remove(module);
            return modules.isEmpty() ? null : modules;
        });
    }

    /**
     * Retrieves the list of students enrolled in the program.
     *
     * @return The list of students enrolled in the program.
     */
    public ArrayList<Student> getStudents() {
        return Students;
    }

    /**
     * Retrieves the name of the program.
     *
     * @return The name of the program.
     */
    public String getProgrammeName() {
        return this.ProgrammeName;
    }

    /**
     * Adds a student to the program.
     *
     * @param student The student to add.
     */
    public void addStudentToProgram(Student student) {
        this.Students.add(student);
    }

    /**
     * Removes a student from the program.
     *
     * @param student The student to remove.
     */
    public void removeStudentFromProgram(Student student) {
        this.Students.remove(student);
    }

    /**
     * Retrieves the level of the program.
     *
     * @return The level of the program.
     */
    public int getProgrammeLevel() {
        return this.ProgrammeLevel;
    }

    /**
     * Finds a student in the program based on their name.
     *
     * @param studentName The name of the student to find.
     * @return The student with the specified name, or null if not found.
     */
    public Student findStudentByName(String studentName) {
        for (Student student : Students) {
            if (student.getName().equals(studentName)) {
                return student;
            }
        }
        return null;
    }
}
