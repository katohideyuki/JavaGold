package sec13_SerializeProxy;

import java.io.Serializable;

/** シリアライズ・プロキシの使用例
      - シリアライズ・プロキシを使用しない例 */
public class Item implements Serializable {
    private String name;
    private int price;

    /* コンストラクタ */
    public Item(String name, int price) {

        // 引数が不正であれば、例外をスロー
        if (name == null || price < 0)
            throw new IllegalArgumentException();

        this.name  = name;
        this.price = price;
    }

    // getter
    public String getName() { return name; }
    public int getPrice()   { return price; }

    @Override /* debug */
    public String toString() {
        return String.format("Item [ name = %s, price = %s ] %n", name, price);
    }

    /* debug - name フィールドをnullを代入し、不正な値をセットする */
    public void nameNull() {
        this.name = null;
    }
}

/**
 * <pre>
 * デシリアライズされるとき、コンストラクタは使われない
 *   - すなわち、引数チェックを経由しないので、不正な値がフィールドに入る可能性がある
 * </pre>
 */
