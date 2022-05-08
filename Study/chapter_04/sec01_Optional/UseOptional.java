package sec01_Optional;

import debug.Debug;

/** Optional クラスの使用例 */
public class UseOptional {

    public static void main(String[] args) {
        useTraditionalPattern_failure();
        useOptionalPattern_failure();
        useOptionalPattern_success();
    }

    /* 要素外へアクセスし、例外が発生したため処理終了 */
    private static void useTraditionalPattern_failure() {
        Debug.log("useTraditionalPattern_failure");
        TraditionalPattern.getValue(3);
    }

    /* 要素外へアクセスし、例外が発生するも、復帰して空の Optional を取得 */
    private static void useOptionalPattern_failure() {
        Debug.log("useOptionalPattern_failure");
        OptionalPattern.getValue(3);
    }

    /* 要素 B を取得 */
    private static void useOptionalPattern_success() {
        Debug.log("useOptionalPattern_success");
        OptionalPattern.getValue(1);
    }
}
