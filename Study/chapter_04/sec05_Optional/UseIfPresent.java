package sec05_Optional;

import java.util.Optional;

import debug.Debug;

/** Optional.ifPresent の使用例 */
public class UseIfPresent {
    public static void main(String[] args) {
        outValEmpty();
        outVal();
    }

    /* 値を出力 - 空のため、何も出力されない */
    private static void outValEmpty() {
        Debug.log("outValEmpty");
        Optional<String> message = Optional.empty();
        processHelper(message);
    }

    /* 値を出力 */
    private static void outVal() {
        Debug.log("outVal");
        Optional<String> message = Optional.of("Hello");
        processHelper(message);
    }

    /* debug - Optional の値を出力する
               空の場合、何もしない */
    private static void processHelper(Optional<String> message) {
        message.ifPresent(System.out::println);
    }
}

/**
 * <pre>
 * Optional.ifPresent(Consumer 型のラムダ式)
 *   - 値を持っていれば、その値を引数に渡してラムダ式を実行
 *   - 値がなければ、何もしない
 * </pre>
 */