package sec03_Optional;

import java.util.Optional;

import debug.Debug;

/** Optional.orElse の使用例 */
public class UseOptionalOrElse {
    static final String EMPTY_MESSAGE = "empty";                   // 空の Optional で出力する文字列
    static final Optional<String> EMPTY_VALUE = Optional.empty();  // 空の Optional

    public static void main(String[] args) {
        fixedfAlternativeVal();
        VariableAlternativeVal();
    }

    /* Optional が空のとき、固定の代替値を返却する - orElse */
    private static void fixedfAlternativeVal() {
        Debug.log("fixedfAlternativeVal");
        System.out.printf("value : %s%n", EMPTY_VALUE.orElse(EMPTY_MESSAGE));
    }

    /* Optional が空のとき、可変の代替値を返却する - orElseGet */
    private static void VariableAlternativeVal() {
        Debug.log("VariableAlternativeVal");
        System.out.printf("value : %s%n", EMPTY_VALUE.orElseGet(EMPTY_MESSAGE::toUpperCase));
    }
}

/**
 * <pre>
 * Optional.orElse(固定の代替値)
 *   - 値を持っていればその値を、空であれば引数で渡した代替値を返却
 *
 * Optional.oeElseGet(可変の代替値)
 *   - 値を持っていればその値を、空であれば、引数の Supplier 型ラムダ式を実行して
 *     その結果を返却
 * </pre>
 */