package practiceExam_Q05;

import java.util.Arrays;
import java.util.List;

import debug.Debug;

/** Q.05 - XXXStream.average の使用例 */
public class UseItem {
    public static void main(String[] args) {
        useAverage();
    }

    /* apple の平均価格を算出する */
    private static void useAverage() {
        Debug.log("useAverage");

        // Item クラスのリストを生成
        List<Item> list = Arrays.asList(
                new Item("apple", 100),
                new Item("banana", 80),
                new Item("apple", 200));

        // apple の平均価格を算出する
        double result = list.stream()
                .filter(e -> e.getName().equals("apple"))   // apple のみに絞る
                .mapToInt(Item::getPrice)                   // price のみに絞る
                .average()                                  // 平均値を出す
                .orElseGet(() -> 0);                        // 値を取り出す

        System.out.printf("Average price of 'apple' : ¥%s%n", result);
    }
}

/**
 * Stream.mapToXXX(Function 型ラムダ)
 *   - average とか max とかの前に使ったりする
 *
 * XXXStream.average()
 *   - 平均値をOptionlに入れて返却する
 */
