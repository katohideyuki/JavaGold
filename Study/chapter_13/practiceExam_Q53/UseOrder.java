package practiceExam_Q53;

import java.util.List;
import java.util.function.BinaryOperator;

import debug.Debug;

/** IntStream.sum, Stream.reduce の使用例 */
public class UseOrder {
    public static void main(String[] args) {
        totalValue();
    }

    /* リスト内の要素を累積的に結合する方法 3パターン */
    private static void totalValue() {
        Debug.log("totalValue");

        // Order を扱うリスト
        List<Order> orderList = List.of(
                new Order("apple", 100),
                new Order("banana", 80)
                );

        // 累積的に要素を結合していく
        BinaryOperator<Integer> op = (a, b) -> a + b;
        int total_A = orderList.stream().map(Order::getPrice).reduce(op).orElse(0);   // 180
        int total_B = orderList.stream().map(Order::getPrice).reduce(0, op);          // 180
        int total_C = orderList.stream().mapToInt(Order::getPrice).sum();             // 180
        System.out.println("""
            total_A : %s
            total_B : %s
            total_C : %s
            """.formatted(total_A, total_B, total_C));
    }
}

/**
 * <pre>
 * ストリーム内の要素を使って数値の合計を算出する方法
 *   - Stream.reduce(任意の戻り値型, BinaryOperator 型)
 *       - IntStream とかには存在しない
 *   - InsStream.sum()
 *       - Stream には存在しない
 * </pre>
 */
