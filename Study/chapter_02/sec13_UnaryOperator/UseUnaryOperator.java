package sec13_UnaryOperator;

import java.util.Arrays;
import java.util.List;

/** UnaryOperator インターフェースの使用例 */
public class UseUnaryOperator {
    public static void main(String[] args) {
        convertToUpperCase();
    }

    /* Stinrg型のリストの値を大文字に変換する */
    private static void convertToUpperCase() {
        List<String> list = Arrays.asList("a", "b", "c");
        list.replaceAll(String::toUpperCase);
        list.stream().forEach(System.out::println);
    }
}

/**
 * <pre>
 * UnaryOperator
 *   - リストの値を一律に処理する場合に処理できる
 *
 * List.replaceAll(UnaryOperator a)
 *   - UnaryOperator型の引数を受け取り、リストの全ての要素をラムダ式の実行結果で置き換える
 *   - String.replaceAll とは違うので注意する
 * </pre>
 */
