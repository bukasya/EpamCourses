package task02;

import org.junit.Test;

import static org.junit.Assert.*;

public class BitSetTest {
    @Test
    public void add() throws Exception {
        final BitSet set = new BitSet();

        assertFalse(set.contains(0));
        assertFalse(set.contains(15));
        assertFalse(set.contains(64));
        assertFalse(set.contains(127));
        assertFalse(set.contains(-1));

        set.add(0);
        set.add(15);
        set.add(64);
        set.add(127);
        set.add(-1);

        assertTrue(set.contains(0));
        assertTrue(set.contains(15));
        assertTrue(set.contains(64) & set.contains(15));
        assertTrue(set.contains(127));

        assertFalse(set.contains(-1));
    }

    @Test
    public void remove() throws Exception {
        final BitSet set = new BitSet();

        assertFalse(set.contains(0));
        set.add(0);
        assertTrue(set.contains(0));
        set.remove(0);
        assertFalse(set.contains(0));
    }

    @Test
    public void contains() throws Exception {
        final BitSet set = new BitSet();

        assertFalse(set.contains(-1));
        assertFalse(set.contains(0));
        assertFalse(set.contains(7));
        assertFalse(set.contains(64));
        assertFalse(set.contains(128));
        assertFalse(set.contains(273));

        set.add(-1);
        set.add(0);
        set.add(7);
        set.add(64);
        set.add(128);
        set.add(273);

        assertFalse(set.contains(-1));
        assertTrue(set.contains(0));
        assertTrue(set.contains(7));
        assertTrue(set.contains(64));
        assertTrue(set.contains(128));
        assertTrue(set.contains(273));

        set.remove(273);
        
        assertFalse(set.contains(273));
    }

    @Test
    public void union() throws Exception {
        final BitSet setFirst = new BitSet();
        final BitSet setSecond = new BitSet();
        BitSet setResult;

        setFirst.add(1);
        setFirst.add(3);

        setSecond.add(2);
        setSecond.add(3);

        setResult = setFirst.union(setSecond);

        assertFalse(setResult.contains(0));

        for(int i = 1; i <= 3; i++){
            assertTrue(setResult.contains(i));
        }
    }

    @Test
    public void intersection() throws Exception {
        final BitSet setFirst = new BitSet();
        final BitSet setSecond = new BitSet();
        BitSet setResult;

        setFirst.add(1);
        setFirst.add(3);

        setSecond.add(2);
        setSecond.add(3);

        setResult = setFirst.intersection(setSecond);

        assertTrue(setResult.contains(3));

        for(int i = 0; i <= 2; i++){
            assertFalse(setResult.contains(i));
        }
    }

    @Test
    public void difference() throws Exception {
        final BitSet setFirst = new BitSet();
        final BitSet setSecond = new BitSet();
        BitSet setResult;

        setFirst.add(1);
        setFirst.add(3);

        setSecond.add(2);
        setSecond.add(3);

        setResult = setFirst.difference(setSecond);

        assertTrue(setResult.contains(1));

        assertFalse(setResult.contains(0));
        assertFalse(setResult.contains(2));
        assertFalse(setResult.contains(3));
    }

    @Test
    public void isSubsetOf() throws Exception {
        final BitSet setFirst = new BitSet();
        final BitSet setSecond = new BitSet();

        assertTrue(setFirst.isSubsetOf(setSecond));

        setSecond.add(2);
        setSecond.add(3);

        assertTrue(setFirst.isSubsetOf(setSecond));

        setFirst.add(3);

        assertTrue(setFirst.isSubsetOf(setSecond));

        setFirst.add(1);

        assertFalse(setFirst.isSubsetOf(setSecond));
    }

}