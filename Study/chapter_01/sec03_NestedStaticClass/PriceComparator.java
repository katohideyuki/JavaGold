package sec03_NestedStaticClass;

import java.util.Comparator;

/** ネストした static なクラス - Comparator を実現したクラス */
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

/**
 * <pre>
 * 並び替え対象となる Item クラスから基準を分離することで、
 * 並び替えの基準を仕様に応じていくつでも作ることができる
 * </pre>
 */
