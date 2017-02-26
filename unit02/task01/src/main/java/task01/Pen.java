package task01;

public class Pen {
    private int price;
    private String producer;

    public Pen(int price, String producer) {
        this.price = price;
        this.producer = producer;

    }

    @Override
    public int hashCode() {
        return (int) (31 * price + ((producer == null) ? 0 : producer.hashCode()));
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(obj.getClass() != this.getClass())
            return false;

        Pen pen = (Pen) obj;

        if(this.price != pen.price)
            return false;
        if(this.producer == null)
            return (this.producer == pen.producer);
        else{
            if(!this.producer.equals(pen.producer))
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + "price: " + price + ", producer: " + producer;
    }
}
