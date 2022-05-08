package sec08_Optional;

import java.util.Optional;

import debug.Debug;

/** Optional.flatMap の使用例 */
public class UseFlatMap {
    static final Optional<String> BEFORE_MESSAGE = Optional.of("hello");

    public static void main(String[] args) {
        NestedOptional();
        useFlatMap();
    }

    /* 小文字から大文字に変換した値を出力する - Optional の入れ子 */
    private static void NestedOptional() {
        Debug.log("NestedOptional");
//        Optional<String> afterMessage =
//                val_A.map(str -> convertLowerToUpper(str));         // コンパイルエラー ※1
        Optional<Optional<String>> afterMessage =
                BEFORE_MESSAGE.map(UseFlatMap::convertLowerToUpper);  // 正しい受け取り方
        afterMessage.ifPresent(
                str -> System.out.printf("value : %s%n  => Nested Optional %n", str));
        afterMessage.get().ifPresent(
                str -> System.out.printf("value : %s%n  => OK %n", str));
    }

    /* 小文字から大文字に変換した値を出力する - flatMap */
    private static void useFlatMap() {
        Debug.log("useFlatMap");
        Optional<String> afterMessage =
                BEFORE_MESSAGE.flatMap(UseFlatMap::convertLowerToUpper);
        afterMessage.ifPresent(
                str -> System.out.printf("value : %s%n  => OK %n", str));

    }

    /* 小文字から大文字に変換した値を Optional でラップして返却 */
    private static Optional<String> convertLowerToUpper(String message) {
        return Optional.of(message.toUpperCase());
    }
}

/**
 * <pre>
 * ※1
 * map メソッドは、Optional<Optional<String>>型の値を返却するが、
 * 戻り値を受け取る変数 afterMessage の型はOptional<String>であるため、
 * 互換性がないとして、コンパイルエラー
 *
 * Optional.flatMap
 *  - 戻り値を新しい Optional インスタンスに入れずにそのまま返却
 * </pre>
 */