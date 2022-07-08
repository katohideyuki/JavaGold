package practiceExam_Q49;

/** Comparator.thenComparing の使用例 */
public class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name  = name;
        this.price = price;
    }

    // getter
    public String getName() { return name; }
    public int getPrice()   { return price; }

    // debug
    @Override
    public String toString() {
        return String.format("%s , %s", getName(), getPrice());
    }
}
