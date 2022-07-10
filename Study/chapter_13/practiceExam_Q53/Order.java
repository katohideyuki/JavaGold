package practiceExam_Q53;

/** IntStream.sum - Stream.reduce */
public class Order {
    private String item;
    private int price;

    /* コンストラクタ */
    public Order(String item, int price) {
        this.item  = item;
        this.price = price;
    }

    /* getter */
    public String getItem() { return item; }
    public int getPrice()   { return price; }
}
