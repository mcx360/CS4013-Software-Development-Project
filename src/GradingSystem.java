public class GradingSystem {
    
    public GradingSystem(){

    }

    public GradingSystem(GradingSystem gradingSystem){
        
    }

    public String getGrade(Double gradeInPercentage){
        Double score = gradeInPercentage;

        double[] gradeScores = {0,30,35,40,48,52,56,60,64,72,80,101};
        String[] grades ={"NG","F","D2","D1","C3","C2","C1","B3","B2","B1","A2","A1"};
        for(int i=0;i<gradeScores.length-1;i++){
            if(score>=gradeScores[i] && score<gradeScores[i+1]){
                return grades[i];
            }
        }
        return "A1";
   }

   public String getGrade(int gradeInPercentage){
        int score = gradeInPercentage;

        int[] gradeScores = {0,30,35,40,48,52,56,60,64,72,80,101};
        String[] grades ={"NG","F","D2","D1","C3","C2","C1","B3","B2","B1","A2","A1"};
        for(int i=0;i<gradeScores.length-1;i++){
            if(score>=gradeScores[i] && score<gradeScores[i+1]){
                return grades[i];
            }
        }
        return "A1";
   }
}
