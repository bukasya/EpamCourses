package task03;

public abstract class Stationery {
    private int price;
    private String producer;

    public int getPrice(){
        return this.price;
    }

    public Stationery(int price, String producer){
        this.price = price;
        this.producer = producer;
    }
}
