package task03;

public class Notebook extends Stationery {
    private int sheets;
    private String size;
    private String cover;

    public Notebook(int price, String producer, int sheets, String size, String cover){
        super(price, producer);
        this.sheets = sheets;
        this.size = size;
        this.cover = cover;
    }
}
