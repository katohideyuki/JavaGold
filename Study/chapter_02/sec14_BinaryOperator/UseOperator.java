package sec14_BinaryOperator;

import java.util.function.BinaryOperator;

/** BinaryOperator インターフェースの使用例 */
public class UseOperator {
    public static void main(String[] args) {
        useAddAndMinus();
    }

    /* 値を加算、減算する */
    private static void useAddAndMinus() {
        BinaryOperator<Integer> opAdd = OperatorFactory.add();
        System.out.printf("add method : %s%n", opAdd.apply(10, 20));

        BinaryOperator<Integer> opMinus = OperatorFactory.minus();
        System.out.printf("minus method : %s%n", opMinus.apply(50, 10));
    }
}

/**
 * <pre>
 * BinaryOperator
 *   - 引数を２つ受け取り、その引数を使った処理の結果を、引数と同じ型で返却する
 * </pre>
 */
