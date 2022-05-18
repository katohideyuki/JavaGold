package sec23_StreamCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import debug.Debug;

/** Stream.Collectors の使用例 */
public class UseItem {

    // Item インスタンスを扱うリスト
    static final List<Item> ITEM_LIST = Arrays.asList(
            new Item(1, ItemType.BOOK, "java", 1980),
            new Item(2, ItemType.BOOK, "Lambda", 2980),
            new Item(3, ItemType.MAGAZINE, "Software", 980),
            new Item(4, ItemType.DVD, "Test", 1280)
            );

    public static void main(String[] args) {
        creBookList();
        creMagazineSet();
        creDvdMap();
    }

    /* 新しいリストを生成 - toList */
    private static void creBookList() {
        Debug.log("creBookList");
        // BOOK のみを扱う新しいリストを生成
        List<Item> bookList =
                ITEM_LIST.stream().filter(item -> item.getType() == ItemType.BOOK)
                                  .collect(Collectors.toList());
        bookList.stream().forEach(System.out::println);
    }

    /* 新しいセットを生成 - toSet */
    private static void creMagazineSet() {
        Debug.log("creMagazineSet");
        // MAGAZINE のみを扱う新しいセットを生成
        Set<Item> magazinSet =
                ITEM_LIST.stream().filter(item -> item.getType() == ItemType.MAGAZINE)
                                  .collect(Collectors.toSet());
        System.out.println(magazinSet);
    }

    /* 新しいマップを生成  - toMap */
    private static void creDvdMap() {
        Debug.log("creDvdMap");

        // 商品名(key) : Item インスタンス(value) 形式の新しいマップを生成
        Map<String, Item> dvdMap =
                ITEM_LIST.stream().collect(Collectors.toMap(
                        Item::getName,   // 商品名
                        item -> item));  // item インスタンス
        dvdMap.keySet().stream().forEach(System.out::println);
    }
}

/**
 * <pre>
 * Collectors.toList()
 *   - ストリームの処理結果を基に、新しいリストを生成
 * </pre>
 */
