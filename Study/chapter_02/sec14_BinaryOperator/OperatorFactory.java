package sec14_BinaryOperator;

import java.util.function.BinaryOperator;

/** BinaryOperator インターフェースの使用例
      - ファクトリークラス */
public class OperatorFactory {

    /* 加算された合計 */
    public static BinaryOperator<Integer> add() {
        return (a, b) -> a + b;
    }

    /* 減算された合計 */
    public static BinaryOperator<Integer> minus() {
        return (a, b) -> a - b;
    }
}

/**
 * <pre>
 * ラムダ式は、OperatorFactory のようなファクトリークラスを使って隠蔽し、
 * 関数型インターフェースだけで扱えるようにすると、可読性や再利用性が高まる
 *   - 関数型インターフェースの定義をまとめたクラス
 * </pre>
 */