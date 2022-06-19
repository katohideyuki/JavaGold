package sec05_IETF;

import java.util.Locale;

/** Locale の使用例 - IETF　言語タグを使用してインスタンス生成 */
public class FactoryIETF {
    public static void main(String[] args) {
        exe();
    }

    /**
     * forLanguageTagメソッド<br>
     * - staticなメソッドで、引数で渡されたIETF言語タグに準拠したlocaleインスタンスを生成して、その参照を戻す<br>
     * --- InternetEngineering Task Froce<br>
     */
    private static void exe() {
        Locale locale = Locale.forLanguageTag("en-US-x-lvariant-POSIX");
        System.out.println(locale);
    }

}

/**
 * <pre>
 * ITEF 言語タグそのものを組み込んだファクトリメソッドを使って、Locale インスタンスを生成
 * Locale.forLanguageTag(IETF言語タグ)
 *   - static なメソッドで、引数で渡された IETF 言語タグに準拠した locale インスタンスを生成して、その参照を返却
 * </pre>
 */
