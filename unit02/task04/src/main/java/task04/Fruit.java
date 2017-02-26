package task04;

public class Fruit {
    private int price;
    private String name;

    public Fruit(int price, String name){
        if(price < 0 || name.equals(null)){
            throw new IllegalArgumentException("Price can't be less than zero and name can't be null");
        }

        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
