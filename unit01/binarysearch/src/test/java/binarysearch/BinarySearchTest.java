package binarysearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    @Test
    public void binarySearch() throws Exception {
        int[] data = {2, 4, 7, 9, 13, 17, 26, 32, 37, 56};

        assertEquals(0, BinarySearch.binarySearch(data, 2));
        assertEquals(9, BinarySearch.binarySearch(data, 56));
        assertEquals(2, BinarySearch.binarySearch(data, 7));
        assertEquals(-1, BinarySearch.binarySearch(data, 273));

    }

}