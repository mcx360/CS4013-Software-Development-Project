import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
public class GradingSystemTest {

    @Test
    public void testA1(){
        GradingSystem defaultGradingSystem = new GradingSystem();
        assertEquals("A1",defaultGradingSystem.getGrade(85.0));
    }

    @Test
    public void testA2(){
        GradingSystem defaultGradingSystem = new GradingSystem();
        assertEquals("A2",defaultGradingSystem.getGrade(77.0));
    }
}
