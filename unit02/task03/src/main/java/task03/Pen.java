package task03;

public class Pen extends Stationery {
    private String color;
    private int thickness;

    public Pen(int price, String producer, String color, int thickness){
        this.setPrice(price);
        this.setProducer(producer);
        this.color = color;
        this.thickness = thickness;
    }
}
