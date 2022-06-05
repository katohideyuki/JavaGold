package sec16_Comparable;

/** Comparable インタフェースの使用例
      - Comparableを実現したクラス */
public class Item implements Comparable<Item> {
    private String name;
    private int price;

    /* コンストラクタ */
    public Item(String name, int price) {
        this.name  = name;
        this.price = price;
    }

    @Override /* price が低い順に並び替える */
    public int compareTo(Item othre) {
        if (this.price < othre.price)   // 自分自身の方が低い = 前なので -1 を返却
            return -1;
        if (othre.price < this.price)   // 自分自身の方が高い = 後ろなので 1 を返却
            return 1;
        return 0;
    }

    @Override /* debug */
    public String toString() {
        return String.format("Item [ name = %s , price = %d ]", name, price);
    }
}

/**
 * <pre>
 * Comparable インタフェース
 *   - 比較可能なオブジェクトであることを示す
 *   - 抽象メソッドの compareTo を実装しなければいけない
 *
 * Comparable.compareTo()
 *   - 「自分自身が相手よりも前」に位置するように並び替えるのであれば、「負の整数」を返却
 *   - 「自分自身が相手よりも後ろ」に位置するように並び替えるのであれば、「正の整数」を返却
 *   - 相手と同値であり、並び替える必要がないのであれば「0」を返却
 * </pre>
 */
