package sec10_Stream;

import java.util.List;

import debug.Debug;

/** Stream.forEach メソッドの使用例 */
public class UseForEach {
    private static final List<Integer> LIST = List.of(1, 2, 3, 4, 5);

    public static void main(String[] args) {
        traditional();
        useForEach();
    }

    /* リストの中身を出力 - 従来のコレクションの使用例 */
    private static void traditional() {
        Debug.log("traditional");
        for (Integer value : LIST)
            System.out.println(value);
    }

    /* リストの中身を出力 - ストリーム API の使用例 */
    private static void useForEach() {
        Debug.log("useForEach");
        LIST.stream().forEach(System.out::println);
    }
}

/**
 * <pre>
 * ストリーム API
 *   - 中間操作が実際に実行されるのは、終端操作を実行したタイミング
 *   - for 文などの繰り返し構文を置き換えることはしない
 *   - ストリーム・パイプライン内からローカル変数の値を変更することはできない
 *
 * Collection.stream()
 *   - List や Set などからストリームを作る
 *
 * Stream.forEach(Consumer のラムダ式)
 *   - ストリーム内の要素を使って繰り返し処理を実行する
 * </pre>
 */