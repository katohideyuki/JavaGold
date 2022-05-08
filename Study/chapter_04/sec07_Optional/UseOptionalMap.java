package sec07_Optional;

import java.util.Optional;


import debug.Debug;

/** Optional.map の使用例 */
public class UseOptionalMap {
    static final Optional<String> BEFORE_MASSAGE = Optional.of("hello");

    public static void main(String[] args) {
        badConvertLowerToUpper();
        goodConvertLowerToUpper();
    }

    /* BEFORE_MESSAGE を大文字に変換して出力する - 悪い例 */
    private static void badConvertLowerToUpper() {
        Debug.log("badConvertLowerToUpper");
        Optional<String> afterMessage  = null;  // 変換後の値を格納
        // 変換前の値を取り出して、変換したあと、変換後の値を新しいOptionalへ代入
        if (BEFORE_MASSAGE.isPresent()) {
            String str   = BEFORE_MASSAGE.get();
            afterMessage = Optional.of(str.toUpperCase());
        }
        processHelper(afterMessage);
    }

    /* BEFORE_MESSAGE を大文字に変換して出力する - 良い例 */
    private static void goodConvertLowerToUpper() {
        Debug.log("goodConvertLowerToUpper");
        Optional<String> afterMessage  = BEFORE_MASSAGE.map(String::toUpperCase);
        processHelper(afterMessage);
    }

    /* debug - 値を出力 */
    private static void processHelper(Optional<String> afterMessage) {
        System.out.printf("Before message : %s%n", BEFORE_MASSAGE.get());
        System.out.printf("After message  : %s%n", afterMessage.get());
    }
}

/**
 * <pre>
 * Optional.map(Function 型のラムダ式)
 *   - Function 型の引数を受け取り、処理結果を持った新しい Optional インスタンスを返却
 *     - 処理する Optional が空の場合、空の Optional を返却
 * </pre>
 */