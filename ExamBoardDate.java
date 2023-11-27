import java.util.StringTokenizer;

/**
   An appointment date.
*/
public class AppointmentDate
{  
   private int year;
   private int month;
   private int day;

   /*
   Add additional code here
   */
  public AppointmentDate (String a) {
   StringTokenizer tokenizer = new StringTokenizer(a, "/");
   this.day = Integer.parseInt(tokenizer.nextToken());
   this.month = Integer.parseInt(tokenizer.nextToken());
   this.year = Integer.parseInt(tokenizer.nextToken());
   }

   public boolean equals(Object other) {
    if (other == this) {
        return true;
    }
    if (!(other instanceof AppointmentDate)) {
        return false;
    }
    AppointmentDate otherDate = (AppointmentDate) other;
    return this.year == otherDate.year && this.month == otherDate.month && this.day == otherDate.day;
   }

   public String toString() {
      return String.format("%d/%d/%d", month, day, year);
   }
}