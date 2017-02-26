package task02;

import task01.Pen;

import java.util.ArrayList;
import java.util.List;

public class Stationery {
    public static void main(String[] args) {
        ArrayList<Pen> list = new ArrayList<>();

        list.add(new Pen(10, "a"));
        list.add(new Pen(10, "bb"));
        list.add(new Pen(33, "ccc"));

        for (Pen pen: list) {
            System.out.println(pen.toString());
        }
    }
}
