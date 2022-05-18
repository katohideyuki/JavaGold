package sec24_StreamCollectors;

/** Stream.Collectors の使用例 */
public class Item {
    private int id;         // 商品ID
    private ItemType type;  // 商品
    private String name;    // 商品名
    private int price;      // 値段

    /* コンストラクタ */
    public Item(int id, ItemType type, String name, int price) {
        this.id    = id;
        this.type  = type;
        this.name  = name;
        this.price = price;
    }

    /* 各 getter */
    public int getId()        { return id; }
    public ItemType getType() { return type; }
    public String getName()   { return name; }
    public int getPrice()     { return price; }

    @Override /* debug */
    public String toString() {
        return String.format(
                "Item [ id = %s, type = %s, name = %s, price = %s ]"
                , id, type, name, price
                );
    }
}
