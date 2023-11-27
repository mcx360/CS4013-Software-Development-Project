import java.util.ArrayList;
import java.util.StringTokenizer;

/**
   An appointment calendar.
*/
public class AppointmentCalendar
{  
   private ArrayList<Appointment> appointments;

   public AppointmentCalendar() {
   appointments = new ArrayList<>();
   }
   
   /*
      Add additional code here.
   */
  public void add (Appointment appointment) {
   appointments.add(appointment);
  }

  public void cancel (Appointment appointment) {
   appointments.remove(appointment);
  }

  public ArrayList<Appointment> getAppointmentsForDay(AppointmentDate day) {
   ArrayList<Appointment> appointmentsForDay = new ArrayList<>();
   for (Appointment appointment : appointments) {
       if (appointment.getDay().equals(day)) {
           appointmentsForDay.add(appointment);
       }
   }
   return appointmentsForDay;
    }
}

  
  
  
