package sec12_UnaryOperator;

import java.util.function.UnaryOperator;

/** UnaryOperator インターフェースの使用例 */
public class UseUnaryOperator {
    public static void main(String[] args) {
        increAndTwice();
    }

    /* インクリメント、または2倍する */
    private static void increAndTwice() {
        UnaryOperator<Integer> num = x -> ++x;
        System.out.printf("num : %s%n", num.apply(10));

        UnaryOperator<Integer> twice = x -> x * 2;
        System.out.printf("twice : %s%n", twice.apply(10));
    }
}

/**
 * <pre>
 * UnaryOperator
 *   - 引数を1つ受け取り、その引数を使った処理の結果を、引数と同じ型で返却する
 * </pre>
 */

