package sec03_NestedStaticClass;

import java.util.Comparator;

/** ネストした static なクラス
      - PriceComparator を実現したクラスをインナークラスとして扱う */
public class PriceComparatorInnerClass implements Comparable<Item> {
    private String name;
    private int price;

    /* コンストラクタ */
    public PriceComparatorInnerClass(String name, int price ) {
        this.name  = name;
        this.price = price;
    }

    /* getter */
    public String getName() { return name; }
    public int getPrice()   { return price; }

    @Override /* 名前を比較する */
    public int compareTo(Item target) {
        return name.compareTo(target.getName());
    }

    /** PriceComparator クラスをインナークラスとして定義
          - 使用するには、エンクロージングクラスのインスタンスが必要 */
    public class PriceComparator implements Comparator<Item> {
        @Override /* 値段が低い順に定義 */
        public int compare(Item a, Item b) {
            if (a.getPrice() < b.getPrice())
                return -1;
            if (b.getPrice() < a.getPrice())
                return 1;
            return 0;
        }
    }

    /** PriceComparator クラスをネストした static なクラスとして定義
          - 使用するには、import する必要がある */
    public static class StaticPriceCompatator implements Comparator<Item> {
        @Override /* 値段が低い順に定義 */
        public int compare(Item a, Item b) {
            if (a.getPrice() < b.getPrice())
                return -1;
            if (b.getPrice() < a.getPrice())
                return 1;
            return 0;
        }
    }
}
