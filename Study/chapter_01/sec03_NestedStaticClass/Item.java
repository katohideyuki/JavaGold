package sec03_NestedStaticClass;

/** ネストした static なクラス
      - Comparable を実現したクラス */
public class Item implements Comparable<Item> {
    private String name;
    private int price;

    /* コンストラクタ */
    public Item(String name, int price) {
        this.name  = name;
        this.price = price;
    }

    /* getter */
    public String getName() { return name; }
    public int getPrice()   { return price; }

    @Override /* 名前を比較する */
    public int compareTo(Item target) {
        return name.compareTo(target.name);
    }
}

/**
 * <pre>
 * 並び替えの基準が1つだけということもあれば、場合によっては並べ替えの基準を変えたいこともある。
 * 例えば、名前ではなく、値段を基準にして並び替えたいような場合。
 * こうした要件は、このような Comparable インタフェースを実現する方法では
 * 満たすことができない
 * </pre>
 */