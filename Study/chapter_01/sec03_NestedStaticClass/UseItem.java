package sec03_NestedStaticClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import debug.Debug;
import sec03_NestedStaticClass.PriceComparatorInnerClass.StaticPriceCompatator;

/** ネストした static なクラス - 並べ替えを行う */
public class UseItem {
    static List<Item> ITEM_LIST = Arrays.asList(
            new Item("orange", 100),
            new Item("banana", 80),
            new Item("apple", 120));

    public static void main(String[] args) {
        useItem();
        usePriceComparator();
        usePriceComparatorInnerClass();
        useStaticPriceComparator();
    }

    /* ITEM_LIST を名前順にソートし、名前を出力 - Comparable インタフェース*/
    private static void useItem() {
        Debug.log("useItem");
        Collections.sort(ITEM_LIST);
        ITEM_LIST.forEach(item -> System.out.println(item.getName()));           // apple, banana, orange
    }

    /* ITEM_LIST を値段順にソートし、値段を出力 - Comparator インタフェース*/
    private static void usePriceComparator() {
        Debug.log("usePriceComparator");
        Collections.sort(ITEM_LIST, new PriceComparator());
        ITEM_LIST.forEach(item -> System.out.println(item.getPrice()));          // 80, 100, 120
    }

    /* ITEM_LIST を値段順にソートし、名前を出力
         - PriceComparator を実現したインナークラス ※1 */
    private static void usePriceComparatorInnerClass() {
        Debug.log("usePriceComparatorInnerClass");
        // 意味のないエンクロージングクラスのインスタンス化をしている
        Collections.sort(ITEM_LIST, new PriceComparatorInnerClass(null, 0).new PriceComparator());
        ITEM_LIST.stream().forEach(item -> System.out.println(item.getName()));  // banana, orange, apple
    }

    /* ITEM_LIST を値段順にソートし、名前を出力
         - PriceComparator を実現したネストした static なクラス ※2 */
    private static void useStaticPriceComparator() {
        Debug.log("useStaticPriceComparator");
        // エンクロージングクラスのインスタンスが必要ない
        Collections.sort(ITEM_LIST, new StaticPriceCompatator());
        ITEM_LIST.stream().forEach(item -> System.out.println(item.getName()));  // banana, orange, apple
    }
}

/**
 * <pre>
 * ※1 インナークラスのインスタンスを生成するには、先にエンクロージングクラスのインスタンスを生成し
 *    そのインタンスへの参照と new 演算子を使う
 *      - PriceComparator クラスは PriceComparatorInnerClass のインナークラスであるため
 *        先に PriceComparatorInnerClass のインスタンス化をしなければならない
 *          - つまり、PriceComparatorInnerClass クラスのインスタンスは、インナークラスのインスタンス
 *            を作るためだけに必要
 * ※2 インナークラスを static で修飾することで、エンクロージングクラスのインスタンスが必要なくなる
 *      - ただし、ネストした static なクラスを使用するときは、import しておく必要がある
 * </pre>
 */
