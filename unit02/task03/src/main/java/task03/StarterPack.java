package task03;

import java.util.ArrayList;

public class StarterPack {
    public static void main(String[] args) {
        ArrayList<Stationery> sp = new ArrayList<>();

        sp.add(new Pen(18, "a", "blue", 1));
        sp.add(new Pen(32, "bb", "black", 2));
        sp.add(new Pencil(11, "a", "grey", 1));
        sp.add(new Notebook(76, "ccc", 48, "a5", "soft"));

        int fullPrice = 0;
        for (Stationery s: sp) {
            fullPrice += s.getPrice();
        }

        System.out.println("Full price: " + fullPrice);
    }
}
