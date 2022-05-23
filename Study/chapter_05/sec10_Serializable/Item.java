package sec10_Serializable;

import java.io.Serializable;

/** Serializable の使用例 - 出力対象のクラス */
public class Item implements Serializable {
    private String name;  // 商品名
    private int price;    // 値段

    /* コンストラクタ */
    public Item(String name, int price) {
        this.name  = name;
        this.price = price;
    }

    // getter
    public String getName() { return name; }
    public int getPrice()   { return price; }

    @Override /* debug */
    public String toString() {
        return String.format("Item [ name = %s, price = %s ]", name, price);
    }
}
