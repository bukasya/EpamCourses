package task02;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class Pen {
    private int price;
    private String producer;

    public Pen(int price, String producer) {
        // TODO: 26.02.2017 if price < 0 
        this.price = price;
        this.producer = producer;
    }

    public Pen(){
        this.price = 0;
        this.producer = "unknown";
    }

    //for consistency
    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return this.price;
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
