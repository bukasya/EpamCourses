package task02;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {
    @Test
    public void getFullPrice() throws Exception {
        Employee emp01 = new Employee();

        emp01.addStationeryItem(new Pen(13, "b"));
        emp01.addStationeryItem(new Pen(64, "cc"));
        emp01.addStationeryItem(new Pen(77, "aaa"));

        assertEquals(154, emp01.getFullPrice());
    }

}