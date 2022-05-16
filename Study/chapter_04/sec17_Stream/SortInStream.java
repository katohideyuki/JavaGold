package sec17_Stream;

import java.util.Arrays;
import java.util.List;

import debug.Debug;

/** Stream.sorted の使用例 */
public class SortInStream {
    public static void main(String[] args) {
        useSorted();
        useItem();
    }

    /* ストリーム内の要素を自然順序で並び替え - sorted */
    private static void useSorted() {
        Debug.log("useSort");
        List<String> list = Arrays.asList("A", "B", "C", "A");
        list.stream().sorted()
                     .forEach(System.out::println);
    }

    /* ストリーム内の要素を自然順序で並び替えができない - Itemクラス */
    private static void useItem() {
        Debug.log("useItem");
        List<Item> list = Arrays.asList(
                new Item("A"),
                new Item("B"),
                new Item("C"),
                new Item("A"));

        // sorted に Comparetor 型のラムダ式を渡す
        list.stream().sorted((a, b) -> a.getName().compareTo(b.getName()))
                     .forEach(System.out::println);

        // 自然順序で並び替えようとすると、ClassCastException が発生する
//        list.stream().sorted()
//                     .forEach(System.out::println);
    }
}

/**
 * <pre>
 * Stream.sorted()
 *   - 自然順序に従って並べ替える
 *
 * Stream.sorted(Comparetor 型のラムダ式)
 *   - 比較対象の2つの引数を受け取り、比較した結果を整数として返却
 * </pre>
 */