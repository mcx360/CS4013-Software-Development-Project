public class GradingSystem {
    
    public GradingSystem(){

    }

    public String getGrade(Double gradeInPercentage){
        try{
        Double score = gradeInPercentage;
        Double[] gradeScores = {0.0,30.0,35.0,40.0,45.0,50.0,55.0,60.0,65.0,70.0,75.0,101.0};
        String[] grades = {"F","D2","D1","C3","C2","C1","B3","B2","B1","A2","A1"};
        for(int i=0;i<gradeScores.length;i++){
            if(score>=gradeScores[i] && score<gradeScores[i+1]){
                return grades[i];
            }
        }
    } catch (IndexOutOfBoundsException e){
        return "NG";
    }
    return "Error";
   }

   //overloaded method incase the grade is given as an int
   public String getGrade(int gradeInPercentage){
    try{
        int score = gradeInPercentage;
        int[] gradeScores = {0,30,35,40,45,50,55,60,65,70,75,101};
        String[] grades = {"F","D2","D1","C3","C2","C1","B3","B2","B1","A2","A1"};
        for(int i=0;i<gradeScores.length;i++){
            if(score>=gradeScores[i] && score<gradeScores[i+1]){
                return grades[i];
            }
        }
    } catch (IndexOutOfBoundsException e){
        return "NG";
    }
    return "Error";
   }
}
