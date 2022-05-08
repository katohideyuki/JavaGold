package sec06_Optional;

import java.util.Optional;

import debug.Debug;

/** Optional.ifPresentOrElse の使用例 */
public class UseIfPresentOrElse {
    public static void main(String[] args) {
        outValEmpty();
        outVal();
    }

    /* 値を出力 - 空のため、空メッセージが出力される */
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

    /* debug - 値を出力する
               空の場合、空メッセージを出力 */
    private static void processHelper(Optional<String> message) {
        message.ifPresentOrElse(
                (str) -> System.out.printf("value is : %s%n", str)   /* 値がある場合の処理 */
                ,  () -> System.out.printf("value is : empty %n"));  /* 値がない場合の処理 */
    }
}

/**
 * <pre>
 * Optional.ifPresentOrElse(Consumer 型のラムダ式, Runnable 型のラムダ式)
 *   - 値がある場合、第一引数で指定したラムダ式を実行
 *   - 値がない場合、第二引数で指定したラムダ式を実行
 * </pre>
 */