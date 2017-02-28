package task06;

import org.junit.Test;

import static org.junit.Assert.*;

public class NuclearSubmarineTest {

    @Test
    public  void testSubmarineIsNotMovingWoutSettingSpeed(){
        NuclearSubmarine submarine = new NuclearSubmarine();

        assertFalse(submarine.isSubmarineMoving());
    }

    @Test
    public void testIsSubmarineMoving() throws Exception {
        NuclearSubmarine submarine = new NuclearSubmarine();

        submarine.makeSubmarineMoving(30);

        assertTrue(submarine.isSubmarineMoving());
    }

}