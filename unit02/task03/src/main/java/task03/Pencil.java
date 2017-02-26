package task03;

public class Pencil extends Stationery{
    private String color;
    private int hardness;

    public Pencil(int price, String producer, String color, int hardness){
        super(price, producer);
        this.color = color;
        this.hardness = hardness;
    }
}
