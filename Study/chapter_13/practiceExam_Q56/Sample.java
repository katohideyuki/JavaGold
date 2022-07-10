package practiceExam_Q56;

import debug.Debug;

/** Enum の使用例 */
public class Sample {
    public static void main(String[] args) {
        useType();
    }

    private static void useType() {
        Debug.log("useType");
        Type type = Type.A;

        // typeによって、代入する Type を決める
        Type type2 = switch (type) {
            case A  -> Type.C;
            default -> Type.B;
        };

        System.out.printf(" type : %s%n type : %s%n", type, type2);
    }
}

/**
 * <pre>
 * 一つの値を変数に代入するための if-else 分は代わりに、switch 式を使用しても良い
 * switch 式の値を使用することで変数を不変にでき、if-elseより可読性が高い
 *   - ちなみにJava14から（プレビュー版ではJava12)
 * </pre>
 */
