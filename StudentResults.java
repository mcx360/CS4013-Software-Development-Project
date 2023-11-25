import java.util.ArrayList;
import java.util.Map;

public class StudentResults implements Results {
    public String getStudentResult(Student student){
        StringBuilder sb = new StringBuilder();
        ArrayList<Module> modules = student.getModules();
        ArrayList<String> Results = new ArrayList<>();
          for(int i=0;i<modules.size();i++){
          Module x = modules.get(i);
         String result =  x.getStudentGrade(student.getID());
          Results.add(result);
          }
         for(int k =0;k<Results.size();k++){
            if(k==Results.size()-1){
            sb.append(modules.get(k)).append("- ").append(Results.get(k));
            }
            else {
            sb.append(modules.get(k)).append("- ").append(Results.get(k)).append(",");
            }  
         }
         return sb.toString();
       }

       public ArrayList<String> getProgrammeResults(Programme programme){
        ArrayList<String> x = new ArrayList<>();
        ArrayList<Student> y = new ArrayList<>();
        y = programme.getStudents();
        
        for(int i = 0;i<y.size();i++){
         Student o = y.get(i);
         x.add(getStudentResult(o));
        }
        return x;
    
        }

        public ArrayList<String> getModuleResults(Module module){
        ArrayList<String> x = new ArrayList<>();
        ArrayList<Student> y = new ArrayList<>();
        y = module.getStudents();
         for(int i = 0;i<y.size();i++){
         Student o = y.get(i);
         x.add(getStudentResult(o));
        }
        return x;
        }


}
