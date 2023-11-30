
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentResults implements Results {
    public String getStudentResult(Student student){
        StringBuilder sb = new StringBuilder();
        List<Module> modules = student.getModules();
        ArrayList<String> Results = new ArrayList<>();
          for(int i=0;i<modules.size();i++){
          Module x = modules.get(i);
         String result =  x.getStudentGrade(student);
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
        List<Student> y = programme.getStudents();
        System.out.println("The grades list for the programme "+programme.getProgrammeName()+" is as follows: ");
        for(int i = 0;i<y.size();i++){
         Student o = y.get(i);
         x.add(getStudentResult(o));
        }
        return x;
    
        }

        public ArrayList<String> getModuleResults(Module module){
        ArrayList<String> x = new ArrayList<>();
        ArrayList<Student> y = module.getStudentsInModule();
        System.out.println("The grades list for the module "+module.getModuleName()+" is as follows: ");
         for(int i = 0;i<y.size();i++){
         Student o = y.get(i);
         x.add(o.getID()+"- Module grade- "+ module.getStudentGrade(o));
        }
        return x;
        }
      
      }