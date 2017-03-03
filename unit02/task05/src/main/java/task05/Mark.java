package task05;

public class Mark<T extends Number> implements Comparable<Mark> {
    private T value;

    public Mark(T value){
        if((Double)value >= 0)
            this.value = value;
        else
            throw new IllegalArgumentException("Mark can't be negative");
    }

    public T getValue() {
        return value;
    }

    @Override
    public int compareTo(Mark other){
        if((Double)this.getValue() < (Double)other.getValue())
            return -1;
        if((Double)this.getValue() > (Double)other.getValue())
            return 1;
        else
            return 0;
    }
}
