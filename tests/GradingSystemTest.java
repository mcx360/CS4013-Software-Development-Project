import org.junit.Test;
import static org.junit.Assert.*;
public class GradingSystemTest {


    @Test
    public void testNG(){
        GradingSystem defaultGtadingSystem = new GradingSystem();
        assertEquals("NG",defaultGtadingSystem.getGrade(122.0));
    }

    @Test
    public void testF(){
        GradingSystem defaultGtadingSystem = new GradingSystem();
        assertEquals("F",defaultGtadingSystem.getGrade(22.0));
    }

    @Test
    public void testD2(){
        GradingSystem defaultGtadingSystem = new GradingSystem();
        assertEquals("D2",defaultGtadingSystem.getGrade(32.0));
    }

    @Test
    public void testD1(){
        GradingSystem defaultGtadingSystem = new GradingSystem();
        assertEquals("D1",defaultGtadingSystem.getGrade(36.0));
    }

    @Test
    public void testC3(){
        GradingSystem defaultGtadingSystem = new GradingSystem();
        assertEquals("C3",defaultGtadingSystem.getGrade(41.0));
    }

    @Test
    public void testC2(){
        GradingSystem defaultGtadingSystem = new GradingSystem();
        assertEquals("C2",defaultGtadingSystem.getGrade(46.0));
    }

    @Test
    public void testC1(){
        GradingSystem defaultGtadingSystem = new GradingSystem();
        assertEquals("C1",defaultGtadingSystem.getGrade(51.0));
    }

    @Test
    public void testB3(){
        GradingSystem defaultGtadingSystem = new GradingSystem();
        assertEquals("B3",defaultGtadingSystem.getGrade(56.0));
    }

    @Test
    public void testB2(){
        GradingSystem defaultGtadingSystem = new GradingSystem();
        assertEquals("B2",defaultGtadingSystem.getGrade(61.0));
    }

    @Test
    public void testB1(){
        GradingSystem defaultGtadingSystem = new GradingSystem();
        assertEquals("B1",defaultGtadingSystem.getGrade(66.0));
    }

    @Test
    public void testA2(){
        GradingSystem defaultGtadingSystem = new GradingSystem();
        assertEquals("A2",defaultGtadingSystem.getGrade(71.0));
    }

    @Test
    public void testA1(){
        GradingSystem defaultGtadingSystem = new GradingSystem();
        assertEquals("A1",defaultGtadingSystem.getGrade(76.0));
    }



    






}
