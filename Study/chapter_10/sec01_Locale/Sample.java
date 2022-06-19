package sec01_Locale;

import java.util.Locale;

import debug.Debug;

/** Locale の使用例 */
public class Sample {
    public static void main(String[] args) {
        outCountryLanguage();
    }

    /* 国・言語情報を出力 */
    private static void outCountryLanguage() {
        Debug.log("outCountryLanguage");
        Locale locale = Locale.getDefault();
        System.out.printf("Country  : %s%n", locale.getCountry());    // JP
        System.out.printf("Language : %s%n", locale.getLanguage());   // ja
    }
}

/**
 * <pre>
 * Locale
 *   - 国や地域に柔軟に対応するためのクラスやインタフェースを提供しており、
 *     そのうち、最も基盤となるクラスが util.Locale クラス
 *       - 地域や言語といった「ローケール情報」を扱う
 *
 * Locale.getDefault()
 *   - 実行しているコンピュータのデフォルトのロケール情報を返却
 *
 * Locale.getCountry()
 *   - 実行しているコンピュータの国情報を返却
 *
 * Locale.getLanguage()
 *   - 実行しているコンピュータの言語情報を返却
 * </pre>
 */
