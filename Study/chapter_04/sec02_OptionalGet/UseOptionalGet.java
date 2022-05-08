package sec02_OptionalGet;

import java.util.NoSuchElementException;
import java.util.Optional;

import debug.Debug;

/** Optional.get の使用例 */
public class UseOptionalGet {
    private static final Optional<String> VALUE = Optional.of("Hello");    // 値を保持した Optional
    private static final Optional<String> EMPTY_VALUE = Optional.empty();  // 空の Optional

    public static void main(String[] args) {
        getVal(VALUE);
        getValFailure(EMPTY_VALUE);
        preCheckGetVal(EMPTY_VALUE);
        preEmptyCheckGetVal(EMPTY_VALUE);
    }

    /* Optional　インスタンスから値を取得 */
    private static void getVal(Optional<String> value) {
        Debug.log("getVal");
        System.out.printf("value : %s%n", value.get());
    }

    /* Optional　インスタンスから値を取得 - 中身がないため例外発生 */
    private static void getValFailure(Optional<String> value) {
        Debug.log("getValFailure");
        try {
            System.out.printf("value : %s%n", value.get());
        } catch (NoSuchElementException e) {
            System.out.printf("value.get failure %n  => %s%n", e);
        }
    }

    /* Optional インスタンスの中身を事前に確認して、値を取得 - isPresent */
    private static void preCheckGetVal(Optional<String> value) {
        Debug.log("preCheckGetVal");
        if (value.isPresent()) {
            System.out.printf("value : %s%n", value.get());
            return;
        }
        System.out.println("value is empty.");
    }

    /* Optional インスタンスの中身を事前に確認して、値を取得 - isEmpty */
    private static void preEmptyCheckGetVal(Optional<String> value) {
        Debug.log("preEmptyCheckGetVal");
        if (value.isEmpty()) {
            System.out.println("value is empty.");
            return;
        }
        System.out.printf("value : %s%n", value.get());
    }
}

/**
 * <pre>
 * Optional.isPresent()
 *   - Optional インスタンスが何らかの値を持っていれば true、空であれば false を返却
 *
 * Optional.isEmpty()
 *   - Optional インスタンスが空であれば true、何らかの値を持っていれば false を返却
 * </pre>
 */
