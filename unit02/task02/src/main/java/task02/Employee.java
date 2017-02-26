package task02;

import java.util.ArrayList;

public class Employee {
    private ArrayList<Pen> stationeryList = new ArrayList<>();

    public void addStationeryItem(Pen pen){
        this.stationeryList.add(pen);
    }

    public int getFullPrice(){
        int fullPrice = 0;

        for (Pen pen: stationeryList) {
            fullPrice += pen.getPrice();
        }

        return fullPrice;
    }
}
