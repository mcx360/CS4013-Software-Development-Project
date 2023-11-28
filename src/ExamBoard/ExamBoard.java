package ExamBoard;
import java.util.StringTokenizer;

public class ExamBoard
{ 
   private String description;
   private ExamBoardDate day;
   private ExamBoardTime from;
   private ExamBoardTime to;

   /*
      Add additional code here
   */
  public ExamBoard(String line) {
   StringTokenizer tokenizer = new StringTokenizer(line);

   this.description = tokenizer.nextToken();
   this.day = new ExamBoardDate(tokenizer.nextToken());
   this.from = new ExamBoardTime(tokenizer.nextToken());
   this.to = new ExamBoardTime(tokenizer.nextToken());
 }

   public String format() {
      return description + " " + day + " " + from + " " + to;
   }

   public ExamBoardDate getDay() {
      return day;
   }  

   public String toString() {
      return String.format("%s %s %s %s", description, day, from, to);
   }
}
