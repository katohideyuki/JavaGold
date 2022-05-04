package sec09_Function;

import java.util.function.Function;

/** Function インターフェースの使用例 */
public class UseFunction {
    public static void main(String[] args) {
        useApply("Use function interFace");
    }

    /* String型の引数を渡し、Integer型で返却する */
    private static void useApply(String str) {
        Function<String, Integer> f = x -> x.length();
        System.out.printf("The word count for the '%s' : %s",str , f.apply(str));
    }
}

/**
 * <pre>
 * Function
 *   - 引数を1つ受け取り、その引数を使った処理の結果を1つ返却する
 * </pre>
 */