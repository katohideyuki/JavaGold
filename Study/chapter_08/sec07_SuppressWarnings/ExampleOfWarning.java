package sec07_SuppressWarnings;

import java.util.ArrayList;
import java.util.List;

/** SupressWarnings アノテーションの使用例 */
public class ExampleOfWarning {

    /* ジェネリクスがないため、警告が発生 */
    static void noGenerics() {
        List list = new ArrayList();
        list.add("warning because there is no generics");
    }

    /* SupressWarnings アノテーションで警告を抑制 */
    @SuppressWarnings({"unchecked", "rawtypes"})
    static void noGenericsSuppresWarn() {
        List list = new ArrayList();
        list.add("warning because there is no generics");
    }

    /* 非推奨メソッド */
    @Deprecated
    static void deprecatedMethod() { }

    /* 今後、削除予定のメソッドのため、使用することを強く抑制した非推奨メソッド */
    @Deprecated(forRemoval = true)
    static void planToDelete() { }

}

/**
 * <pre>
 * SupressWarnings アノテーション
 *   - 意図していなかった箇所の警告と混同しないよう、警告を抑制（オフ）にする
 *     - unchecked   : コンパイル時の警告を抑制
 *     - deprecation : 非推奨の Deprecated アノテーションで発生する警告を抑制
 *     - removal     : Depricated(forRemoval = true) アノテーションで発生する警告を抑制
 *
 * Deprecated アノテーション (補足)
 *   - 非推奨だけではなく、今後のリリースで削除が予定されているため、より強く使用を抑制したい場合
 *     @Deprecated(forRemoval = true) と設定する
 * </pre>
 */
