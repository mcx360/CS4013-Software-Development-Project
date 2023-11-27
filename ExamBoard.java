import java.util.StringTokenizer;

/**
   An appointment.
*/
public class Appointment
{ 
   private String description;
   private AppointmentDate day;
   private AppointmentTime from;
   private AppointmentTime to;

   /*
      Add additional code here
   */
  public Appointment(String line) {
   StringTokenizer tokenizer = new StringTokenizer(line);

   this.description = tokenizer.nextToken();
   this.day = new AppointmentDate(tokenizer.nextToken());
   this.from = new AppointmentTime(tokenizer.nextToken());
   this.to = new AppointmentTime(tokenizer.nextToken());
 }

   public String format() {
      return description + " " + day + " " + from + " " + to;
   }

   public AppointmentDate getDay() {
      return day;
   }  

   public String toString() {
      return String.format("%s %s %s %s", description, day, from, to);
   }
}
