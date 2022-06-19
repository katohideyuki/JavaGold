package sec04_Builder;

import java.util.Locale;

import debug.Debug;

/** Locale の使用例 - Builder を使用してインスタンス生成 */
public class UseItem {
    public static void main(String[] args) {
        creItem();
        creLocale();
    }

    /* Item インスタンス生成 */
    private static void creItem() {
        Debug.log("creItem");
        Item item = new Item.Builder("Java", 1000).code(1).build();
        System.out.print(item);
    }

    /* Locale.Builder を使って、Locale インスタンスを生成 */
    private static void creLocale() {
        Debug.log("creLocale");
        Locale locale = new Locale.Builder().setLanguage("jp").setRegion("JP").build();
        System.out.println(locale);
    };
}

/**
 * <pre>
 * Locale クラスはあらかじめ、ネストした static な Builder クラスを既に定義されている
 * </pre>
 **/