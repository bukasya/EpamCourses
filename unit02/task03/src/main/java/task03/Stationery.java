package task03;

public abstract class Stationery {
    private int price;
    private String producer;

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setProducer(String producer){
        this.producer = producer;
    }

    public Stationery(int price, String producer){
        this.price = price;
        this.producer = producer;
    }

    public Stationery(){
        this.price = 0;
        this.producer = "unknown";
    }
}
