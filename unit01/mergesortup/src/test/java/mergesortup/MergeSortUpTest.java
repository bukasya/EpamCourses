package mergesortup;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortUpTest {
    @Test
    public void sort() throws Exception {
        //assign
        int[] data = {50, 34, 18, 10, 13, 78, 1, 7, 12, 0, -90, 3, -5};

        //act
        MergeSortUp.sort(data);

        //assert
        assertEquals(-90, data[0]);
        assertEquals(78, data[12]);
        assertEquals(-5, data[1]);
        assertEquals(0, data[2]);
    }

}