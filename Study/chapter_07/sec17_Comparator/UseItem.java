package sec17_Comparator;

import java.util.Arrays;
import java.util.List;

import debug.Debug;

/** Comparator インタフェースの使用例 */
public class UseItem {
    public static void main(String[] args) {
        sortByName();
        sortByPrice();
    }
    /* 名前順に並び替える
         - sort に引数を渡し、ItemNameComparator.compare メソッドを呼び出す */
    private static void sortByName() {
        Debug.log("sortByName");
        List<Item> itemList = creItemListHelper();
        // sort に ItemNameComparator クラスを渡す
        itemList.stream().sorted(new ItemNameComparator())
                         .forEach(System.out::println);
    }

    /* 値段順に並び替える
         - sort に引数を渡さず、Item.compareTo メソッドを呼び出す */
    private static void sortByPrice() {
        Debug.log("sortByPrice");
        List<Item> itemList = creItemListHelper();
        // sort に引数を渡さない
        itemList.stream().sorted().forEach(System.out::println);
    }

    /* debug - Item インスタンスの集合を扱う List を返却 */
    private static List<Item> creItemListHelper() {
        List<Item> itemList = Arrays.asList(
                new Item("apple", 100),
                new Item("orange", 120),
                new Item("banana", 80));
        return itemList;
    }
}

/**
 * <pre>
 * Stream.sorted
 *   - Comparator を実現したクラスを引数に渡すことで、
 *     compare メソッドが呼び出されることになる
 * </pre>
 */
