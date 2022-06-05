package sec17_Comparator;

/** Comparator インタフェースの使用例
      - Comparableを実現したクラス */
public class Item implements Comparable<Item> {
    private String name;
    private int price;

    /* コンストラクタ */
    public Item(String name, int price) {
        this.name  = name;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice()   { return price; }

    @Override /* price が低い順に並び替える */
    public int compareTo(Item othre) {
        System.out.println("Item.compareTo was executed");
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
