package sec16_Comparable;

import java.util.Arrays;
import java.util.List;

import debug.Debug;

/** Comparable インタフェースの使用例 */
public class UseItem {
    public static void main(String[] args) {
        sorting();
    }

    /* 並び替えを行う */
    private static void sorting() {
        Debug.log("sorting");
        List<Item> itemList = Arrays.asList(
                new Item("apple", 100),
                new Item("orange", 120),
                new Item("banana", 80));
        itemList.stream().sorted().forEach(System.out::println);
    }
}

/**
 * <pre>
 * sorted メソッド内部で compareTo メソッドが呼び出されている
 * </pre>
 */
