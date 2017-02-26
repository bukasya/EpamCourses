package task04;

import java.util.Comparator;

public class Sorter implements Comparator<Fruit>{
    private CompareMethod compareMethod;

    public Sorter(CompareMethod compareMethod){
        this.compareMethod = compareMethod;
    }
    public int compare(Fruit f1, Fruit f2){
        switch (compareMethod){
            case byPrice:
                return compareByPrice(f1, f2);
            case byName:
                return f1.getName().compareTo(f2.getName());
            case byPriceAndName:
                if(compareByPrice(f1, f2) == 0)
                    return f1.getName().compareTo(f2.getName());
                else
                    return compareByPrice(f1, f2);
            default:
                return compareByPrice(f1, f2);
        }
    }

    private int compareByPrice(Fruit f1, Fruit f2){
        if(f1.getPrice() < f2.getPrice())
            return -1;
        if(f1.getPrice() > f2.getPrice())
            return 1;
        else
            return 0;
    }
}
