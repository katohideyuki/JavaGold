package practiceExam_Q49;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import debug.Debug;

/** Comparator.thenComparing の使用例 */
public class Sample {
    public static void main(String[] args) {
        changeList();
    }

    private static void changeList() {
        Debug.log("changeList");

        // Item リスト
        List<Item> item_List = new ArrayList<>(List.of(
                new Item("banana", 100),
                new Item("apple", 80),
                new Item("orange", 80)
                ));

        // Item リスト内を price の値でソートする
        // price が等しい場合、name でソートする
        item_List.sort(
                Comparator.comparing(Item::getPrice)
                .thenComparing(Item::getName)
                .reversed());

        item_List.forEach(System.out::println);
    }
}

/**
 * <pre>
 * Comparator.comparing()
 *   - 並べ替えで利用するキーを受け取り、そのキーを使って並べ替える Comparator 型オブジェクトを返却する
 *
 * Comparator.thenComparing()
 *   - 比較対象の2つが等しいと判断した場合、追加の条件で並び替える
 * </pre>
 */
