package sec03_LocaleConstant;

import java.util.Locale;

import debug.Debug;

/** Locale の使用例 - ロケール定数を使用してインスタンス生成 */
public class LocaleConstant {
    static final Locale LOCALE_JAPAN         = Locale.JAPAN;            // 日本
    static final Locale LOCALE_AMERICA       = Locale.US;               // アメリカ
    static final Locale LOCALE_CANADA        = Locale.CANADA;           // カナダ
    static final Locale LOCALE_CANADA_FRENCH = Locale.CANADA_FRENCH;    // フランス言を使用するカナダ
    static final Locale LOCALE_UK            = Locale.UK;               // イギリス

    public static void main(String[] args) {
        outLocale();
    }

    /* Locale を出力 */
    private static void outLocale() {
        Debug.log("outLocale");
        System.out.printf("Japan         : %s%n", LOCALE_JAPAN);
        System.out.printf("America       : %s%n", LOCALE_AMERICA);
        System.out.printf("Canada        : %s%n", LOCALE_CANADA);
        System.out.printf("Canada french : %s%n", LOCALE_CANADA_FRENCH);
        System.out.printf("England       : %s%n", LOCALE_UK);
    }
}

/**
 * <pre>
 * ロケール定数は、すべての地域や言語の組み合わせを網羅しているわけではない
 * </pre>
 */
