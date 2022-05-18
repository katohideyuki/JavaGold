package sec25_StreamCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import debug.Debug;

/** Collectors.summingInt の使用例 */
public class UseSummingInt {
    public static void main(String[] args) {
        pricePerGroup();
        useBook();
    }

    /* グループごとの値段の合計値を出力 */
    private static void pricePerGroup() {
        Debug.log("pricePerGroup");
        List<Item> itemList = Arrays.asList(
                new Item(1, ItemType.BOOK, "java", 1980),
                new Item(2, ItemType.BOOK, "Lambda", 2980),
                new Item(3, ItemType.MAGAZINE, "Software", 980),
                new Item(4, ItemType.MAGAZINE, "Test", 1280));

        // Item.type : Integer 形式の Map を生成
        Map<ItemType, Integer> group =
                itemList.stream().collect(
                        Collectors.groupingBy(
                                Item::getType,                            // key
                                Collectors.summingInt(Item::getPrice)));  // value
        System.out.println(group);
    }

    /* グループごとの値段の合計値を出力 - 設問25 */
    private static void useBook() {
        Debug.log("useBook");

        // Book.title : Integer 形式の Map を生成
        Map<String, Integer> bookMap = Arrays.asList(
                new Book("A", 1000),
                new Book("B", 2000),
                new Book("A", 500)
                ).stream().collect(Collectors.groupingBy(
                        Book::getTitle,                                   // key
                        Collectors.summingInt(Book::getPrice)));          // value
        bookMap.forEach((k, v) -> System.out.printf("%s : %s%n", k, v));
    }
}

/**
 * Collectors.summingInt()
 *   - グルーピングして、グループ内の要素が持つ数値の合計値を計算
 *   - summingLong, summingDouble などもある
 */