import java.util.ArrayList;

/**
   An appointment calendar.
*/
public class ExamBoardCalendar
{  
   private ArrayList<ExamBoard> appointments;

   public ExamBoardCalendar() {
   appointments = new ArrayList<>();
   }
   
   /*
      Add additional code here.
   */
  public void add (ExamBoard appointment) {
   appointments.add(appointment);
  }

  public void cancel (ExamBoard appointment) {
   appointments.remove(appointment);
  }

  public ArrayList<ExamBoard> getAppointmentsForDay(ExamBoardDate day) {
   ArrayList<ExamBoard> appointmentsForDay = new ArrayList<>();
   for (ExamBoard appointment : appointments) {
       if (appointment.getDay().equals(day)) {
           appointmentsForDay.add(appointment);
       }
   }
   return appointmentsForDay;
    }
}

  
  
  
