import java.util.StringTokenizer;

/**
   An appointment date.
*/
public class ExamBoardDate
{  
   private int year;
   private int month;
   private int day;

   /*
   Add additional code here
   */
  public ExamBoardDate (String a) {
   StringTokenizer tokenizer = new StringTokenizer(a, "/");
   this.day = Integer.parseInt(tokenizer.nextToken());
   this.month = Integer.parseInt(tokenizer.nextToken());
   this.year = Integer.parseInt(tokenizer.nextToken());
   }

   public boolean equals(Object other) {
    if (other == this) {
        return true;
    }
    if (!(other instanceof ExamBoardDate)) {
        return false;
    }
    ExamBoardDate otherDate = (ExamBoardDate) other;
    return this.year == otherDate.year && this.month == otherDate.month && this.day == otherDate.day;
   }

   public String toString() {
      return String.format("%d/%d/%d", month, day, year);
   }
}
