package sec02_LocaleInstance;

import java.util.Locale;

import debug.Debug;

/** Locale の使用例 - コンストラクタを使用してインスタンス生成 */
public class SampleLocale {
    public static void main(String[] args) {
        creLocaleInstance();
    }

    private static void creLocaleInstance() {
        Debug.log("creLocaleInstance");

        // コンストラクタには3パターンある
        Locale firstLocale  = new Locale("ja");                 // 引数に「言語」
        Locale secondLocale = new Locale("ja", "JP");           // 引数に「言語、国」
        Locale thirdLocale  = new Locale("ja", "JP", "MAC");    // 引数に 「言語、国、派生情報」※1

        System.out.println(firstLocale);
        System.out.println(secondLocale);
        System.out.println(thirdLocale);
    }
}

/**
 * <pre>
 * Loale のインスタンス生成方法は5つある
 *   1. Locale.getDefault()
 *   2. コンストラクタ
 *     - ※1 派生情報は、ベンダーまたはブラウザに固有するコード
 *   3. ロケール定数
 *   4. ビルダー
 *   5. ファクトリメソッド
 * </pre>
 */
