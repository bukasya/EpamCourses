package task04;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SorterTest {

    ArrayList<Fruit> fruits = new ArrayList<>();
    Fruit fruit01 = new Fruit(10, "apple");
    Fruit fruit02 = new Fruit(23, "pear");
    Fruit fruit03 = new Fruit(9, "plum");
    Fruit fruit04 = new Fruit(41, "orange");
    Fruit fruit05 = new Fruit(23, "banana");

    {fruits.add(fruit01);
    fruits.add(fruit02);
    fruits.add(fruit03);
    fruits.add(fruit04);
    fruits.add(fruit05);}

    @Test
    public void sortByPrice() throws Exception {
        fruits.sort(new Sorter(CompareMethod.byPrice));
        assertEquals(fruit03, fruits.get(0));
        assertEquals(fruit04, fruits.get(4));
    }

    @Test
    public void sortByName() throws Exception{
        fruits.sort(new Sorter(CompareMethod.byName));
        assertEquals(fruit01, fruits.get(0));
        assertEquals(fruit03, fruits.get(4));
    }

    @Test
    public void sortByPriceAndName() throws Exception{
        fruits.sort(new Sorter(CompareMethod.byPriceAndName));
        assertEquals(fruit05, fruits.get(2));
        assertEquals(fruit02, fruits.get(3));
    }
}