package sec04_Optional;

import java.util.Optional;

import debug.Debug;

/** Optional.orElseThrow の使用例 */
public class UseOptionalOrElseThrow {
    public static void main(String[] args) {
        getValFailure();
        getVal();
    }

    /* Optional の値を取得 - 空のため、エラーメッセージが出力 */
    private static void getValFailure() {
        Debug.log("getValFailure");
        Optional<String> emptyValue = Optional.empty();
        processHelper(emptyValue);
    }

    /* Optional の値を取得 */
    private static void getVal() {
        Debug.log("getVal");
        Optional<String> value = Optional.of("Hello");
        processHelper(value);
    }

    /* debug - Optional の値を取得し、出力する
               空の場合 Exception を発生させ、エラーメッセージを出力 */
    private static void processHelper(Optional<String> value) {
        try {
            System.out.printf("value : %s%n", value.orElseThrow(Exception::new));
        } catch (Exception e) {
            System.out.printf("getVal failure %n  => %s%n", e);
        }
    }
}

/**
 * <pre>
 * Optional.orElseThrow(Throwable 型を返却する Supplier 型ラムダ式)
 *   - Optional.get() がスローする非検査例外である NoSuchElementException の代わりに
 *     任意の検査例外をスローできる
 * </pre>
 */