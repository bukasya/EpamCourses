package task02;

public class Stationery {
    public static void main(String[] args) {
        Employee emp01 = new Employee();

        emp01.addStationeryItem(new Pen(10, "a"));
        emp01.addStationeryItem(new Pen(20, "b"));
        emp01.addStationeryItem(new Pen(44, "ccc"));

        Employee emp02 = new Employee();

        emp02.addStationeryItem(new Pen(23, "a"));
        emp02.addStationeryItem(new Pen(44, "ppp"));

        System.out.println("emp01 full price: " + emp01.getFullPrice());
        System.out.println("emp02 full price: " + emp02.getFullPrice());
    }
}
