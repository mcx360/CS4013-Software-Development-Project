import java.io.IOException;

/**
   A system to manage appointments.
*/
public class ExamBoardSystem
{  
   public static void main(String[] args)
        throws IOException
   { 
      ExamBoardMenu menu = new ExamBoardMenu();
      menu.run();
   }
}
