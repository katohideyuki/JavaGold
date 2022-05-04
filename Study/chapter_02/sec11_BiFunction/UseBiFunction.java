package sec11_BiFunction;

import java.util.function.BiFunction;

/** BiFunction インターフェースの使用例 */
public class UseBiFunction {
    public static void main(String[] args) {
        concatenation();
    }

    /* 文字列結合 */
    private static void concatenation() {
        BiFunction<String, String, String> b = String::concat;  // 全部同じ型だから、本来はBiOperatorで定義すべき
        String result = b.apply("Hello ", "Lambda");
        System.out.println(result);
    }
}

/**
 * <pre>
 * BiFunction
 *   - 引数を２つ受け取り、その引数を使った処理の結果を1つ返却する
 *
 * a.concat(b)
 *   - a と b の文字列を連結する
 * </pre>
 */