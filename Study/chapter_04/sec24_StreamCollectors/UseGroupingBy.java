package sec24_StreamCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import debug.Debug;

/** Collectors.groupingBy の使用例 */
public class UseGroupingBy {
    public static void main(String[] args) {
        groupByType();
    }

    /* Item.type でグループ分け */
    private static void groupByType() {
        Debug.log("groupByType");
        List<Item> itemList = Arrays.asList(
                new Item(1, ItemType.BOOK, "java", 1980),
                new Item(2, ItemType.BOOK, "Lambda", 2980),
                new Item(3, ItemType.MAGAZINE, "Software", 980),
                new Item(4, ItemType.MAGAZINE, "Test", 1280));

        // Item.type : List<Item> 形式の Map を生成
        Map<ItemType, List<Item>> group =
                itemList.stream().collect(Collectors.groupingBy(Item::getType));
        System.out.println(group);
    }
}

/**
 * Collectors.groupingBy(Function 型ラムダ式)
 *   - 2つのリストを作る
 *   - グルーピングされた Map を返却
 *     - Key   : ラムダ式で返却する型
 *     - Value : グルーピングされた要素のリスト
 */