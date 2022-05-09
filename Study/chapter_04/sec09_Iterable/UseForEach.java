package sec09_Iterable;

import java.util.List;

import debug.Debug;

/** Iterable インターフェースの使用例 */
public class UseForEach {
    public static void main(String[] args) {
        repeatOut();
    }

    /* 繰り返し出力 */
    private static void repeatOut() {
        Debug.log("repeatOut");
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        list.forEach(System.out::println);
    }
}

/**
 * <pre>
 * Iterable.forEach(Consumer 型ラムダ式)
 *   - コレクションから要素を順番に取り出しながら、
 *     引数に渡された Consumer 型ラムダ式を実行する
 * </pre>
 */
