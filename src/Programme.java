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
private Map<Integer,Map<Integer,List <Module>>>moduleMap;

public Programme(String ProgrammeName,int Duration,int ProgrammeLevel,ArrayList<Student> Students,Map<Integer,Map<Integer,List <Module>>> moduleMap){
this.ProgrammeName = ProgrammeName;
this.ProgrammeLevel = ProgrammeLevel;
this.Duration = Duration;  
this.Students = Students;  
this.ProgrammeID = Integer.parseInt(ProgrammeName);
this.moduleMap = moduleMap;

}

public Programme(Programme programme){
this.ProgrammeName = programme.ProgrammeName;
this.ProgrammeLevel = programme.ProgrammeLevel;
this.Duration = programme.Duration;  
this.Students = programme.Students;  
this.ProgrammeID = Integer.parseInt(programme.ProgrammeName);
this.moduleMap = programme.moduleMap;
}

public double getAvgQCA(){
    double result=0;
for(int i=0;i<Students.size();i++){
    Student x = Students.get(i);
   result += x.calculateQca();

}
return result/Students.size();

}
public List<Module> getModules(int year,int semester){
List<Module> empty= new ArrayList<>();
    if(moduleMap.containsKey(year)){
        Map<Integer,List<Module>> SemesterMap = moduleMap.get(year);
        if(SemesterMap.containsKey(semester)){
             return SemesterMap.get(semester);
        }
    }
 return empty;
}
public void addModule(int year,int semester,Module module){
    if(moduleMap.containsKey(year)){
    Map<Integer,List<Module>>semesterMap = moduleMap.get(year);
     if(semesterMap.containsKey(semester)){
    List<Module> modules = semesterMap.get(semester);
    modules.add(module);
     }
    }
}
public void removeModule(int year, int semester,Module module){
    if(moduleMap.containsKey(year)){
     Map<Integer,List<Module>> semestermap = moduleMap.get(year);
     if(semestermap.containsKey(semester)){
     List<Module>modules = semestermap.get(semester);
     modules.remove(module);
     }
    }

}

public ArrayList<Student> getStudents(){
    return Students;
}

    
}