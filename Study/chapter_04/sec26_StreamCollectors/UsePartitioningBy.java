package sec26_StreamCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import debug.Debug;

/** Collectors.partitioningBy の使用例 */
public class UsePartitioningBy {
    public static void main(String[] args) {
        diviedByPrice();
        diviedByNumberCharacters();
    }

    /* 条件によって、グループ分けをする */
    private static void diviedByPrice() {
        Debug.log("diviedByPrice");
        List<Item> itemList = Arrays.asList(
                new Item(1, ItemType.BOOK, "java", 1980),
                new Item(2, ItemType.BOOK, "Lambda", 2980),
                new Item(3, ItemType.MAGAZINE, "Software", 980),
                new Item(4, ItemType.MAGAZINE, "Test", 1280));

        // 値段が1,000円かどうかで振り分ける
        Map<Boolean, List<Item>> itemMap =
                itemList.stream().collect(Collectors.partitioningBy(
                        item -> item.getPrice() > 1000));
        System.out.println(itemMap);
    }

    /* 条件によって、グループ分けをする - 設問26 */
    private static void diviedByNumberCharacters() {
        Debug.log("deviedByNumberCharacters");
        List<String> list = Arrays.asList("banana", "apple", "orange");
        // 5文字以上かどうかで振り分け、Map キーの集合だけを取り出す
        Stream<String> stream = list.stream();
        Set<Boolean> keys = stream.collect(Collectors.partitioningBy(
                str -> str.length() > 5)
                ).keySet();
        keys.forEach(System.out::println);
    }
}

/**
 * <pre>
 * Collectors.partitioning()
 *   - 条件によってグループ分けをする
 *   - Map を返却
 *     - key   : true / false
 *     - value : 条件に合致した要素 / しなかった要素
 * </pre>
 */