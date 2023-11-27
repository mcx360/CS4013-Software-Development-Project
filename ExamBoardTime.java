import java.util.StringTokenizer;

/**
   An appointment time.
*/
public class AppointmentTime
{ 
   private int hours;
   private int minutes;

   /*
     Add additional code here 
       */
   public AppointmentTime(String timeStr) {
      StringTokenizer tokenizer = new StringTokenizer(timeStr, ":");
      this.hours = Integer.parseInt(tokenizer.nextToken());
      this.minutes = Integer.parseInt(tokenizer.nextToken());
   }
   
   public String toString() {
      return String.format("%02d:%02d", hours, minutes);
   }
}