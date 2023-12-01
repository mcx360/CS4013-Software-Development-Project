import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Programme
 */
public class Programme {
    private String ProgrammeName;
    private int Duration;
    private int ProgrammeLevel;
    private int ProgrammeID;
    private ArrayList<Student> Students;
    private Map<Map.Entry<Integer, Integer>, ArrayList<Module>> moduleMap;
    private Department department;

    /* 
    public Programme(String ProgrammeName, int Duration, int ProgrammeLevel, ArrayList<Student> Students,Map<Map.Entry<Integer, Integer>, ArrayList<Module>> moduleMap){
        this.ProgrammeName = ProgrammeName;
        this.ProgrammeLevel = ProgrammeLevel;
        this.Duration = Duration;
        this.Students = Students;
        this.moduleMap = new HashMap<>(moduleMap);
    }

    public Programme(String ProgrammeName, int Duration, int ProgrammeLevel, ArrayList<Student> Students) {
        this.ProgrammeName = ProgrammeName;
        this.ProgrammeLevel = ProgrammeLevel;
        this.Duration = Duration;
        this.Students = Students;
        this.moduleMap = new HashMap<>();
    }
    */

    public Programme(String ProgrammeName, int Duration, int ProgrammeLevel,Department department){
        this.department = department;
        this.ProgrammeName = ProgrammeName;
        this.ProgrammeLevel = ProgrammeLevel;
        this.Duration = Duration;
        this.Students = new ArrayList<>();
        this.moduleMap = new HashMap<>();
    }

    public double getAvgQCA() {
        double result = 0;
        for (int i = 0; i < Students.size(); i++) {
            Student x = Students.get(i);
            result += x.calculateTotalAverageQCA(x);
        }
        return result / Students.size();
    }

    public Module getModule(String moduleCode){
        List<Module> allModules = new ArrayList<>();
        for(int i=0;i<allModules.size();i++){
            if(allModules.get(i).getModuleCode().equals(moduleCode)){
                return allModules.get(i);
            }
        }
        return null;
    }

    public List<Module> getModules(int year, int semester) {
        List<Module> empty = new ArrayList<>();
        Map.Entry<Integer, Integer> key = Map.entry(year, semester);
        if (moduleMap.containsKey(key)) {
            return moduleMap.get(key);
        }
        return empty;
    }

    public List<Module> getModules(){
        List<Module> allModules = new ArrayList<>();

        // Iterate through the values of the moduleMap
        for (ArrayList<Module> moduleList : moduleMap.values()) {
            allModules.addAll(moduleList);
        }

        return allModules;
    }

    public void addModule(int year, int semester, Module module) {
        Map.Entry<Integer, Integer> key = Map.entry(year, semester);
        this.moduleMap.put(key, new ArrayList<>()); 
        this.moduleMap.get(key).add(module);
    }

    public void removeModule(int year, int semester, Module module) {
        Map.Entry<Integer, Integer> key = Map.entry(year, semester);
        moduleMap.computeIfPresent(key, (k, modules) -> {
            modules.remove(module);
            return modules.isEmpty() ? null : modules;
        });
    }

    public ArrayList<Student> getStudents() {
        return Students;
    }

    public String getProgrammeName() {
        return this.ProgrammeName;
    }

    public void addStudentToProgram(Student student) {
        this.Students.add(student);
    }

    public void removeStudentFromProgram(Student student){
        this.Students.remove(student);
    }

    public int getProgrammeLevel() {
        return this.ProgrammeLevel;
    }

}
