import java.util.Scanner;
import java.util.ArrayList;


/**
   A menu for the appointment calendar system.
*/
public class ExamBoardMenu
{
   private Scanner in;

   /**
      Constructs an AppointmentMenu object.
   */
   public ExamBoardMenu()
   {
       in = new Scanner(System.in);
   }
   
   /**
      Runs the system.
   */
   public void run()
   {         
      boolean more = true;
      ExamBoardCalendar calendar = new ExamBoardCalendar();
  
      while (more)
      {  
         System.out.println("A)dd  C)ancel  S)how  Q)uit");
         String command = in.nextLine().toUpperCase();

         if (command.equals("A"))
         {  
            System.out.println("Exam Board (Description Date From To)");
            String line = in.nextLine();
            ExamBoard a = new ExamBoard(line);
            calendar.add(a);
         }
         else if (command.equals("C"))
         { 
            System.out.println("Enter Exam Board Date");
            String line = in.nextLine();
            ExamBoardDate day = new ExamBoardDate(line);
            ExamBoard a = getChoice(calendar.getAppointmentsForDay(day));
            if (a != null)
               calendar.cancel(a);
         }
         else if (command.equals("S"))
         { 
            System.out.println("Date");
            String line = in.nextLine();
            ExamBoardDate day = new ExamBoardDate(line);
            for (ExamBoard appt : calendar.getAppointmentsForDay(day))
               System.out.println(appt.format());
         }
         else if (command.equals("Q"))
         { 
            more = false;
         }
      }      
   }

   private ExamBoard getChoice(ArrayList<ExamBoard> choices)
   {
      if (choices.size() == 0) return null;
      while (true)
      {
         char c = 'A';
         for (ExamBoard choice : choices)
         {
            System.out.println(c + ") " + choice.format()); 
            c++;
         }
         String input = in.nextLine();
         int n = input.toUpperCase().charAt(0) - 'A';
         if (0 <= n && n < choices.size())
            return choices.get(n);
      }      
   }
}
