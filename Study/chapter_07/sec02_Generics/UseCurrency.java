package sec02_Generics;

import debug.Debug;

/** ジェネリクスの使用例 */
public class UseCurrency {
    public static void main(String[] args) {
        creCurrencyDouble();
        creCurrencyInteger();
    }

    /* Double 型だけを扱う Currency のインスタンス生成 */
    private static void creCurrencyDouble() {
        Debug.log("creCurrencyDouble");
        Currency<Double> currency = new Currency<Double>(7.25);
        System.out.println(currency.getAmount());
    }

    /* Integer 型だけを扱う Currency のインスタンス生成 */
    private static void creCurrencyInteger() {
        Debug.log("creCurrencyInteger");
        Currency<Integer> currency = new Currency<Integer>(100);
        System.out.println(currency.getAmount());
    }
}

/**
 * <pre>
 * 総称型
 *   - ジェネリクスを使ったクラスのこと
 *   - 型パラメータを使う時に、型パラメータを指定しなかった場合、Object 型となる
 *   - ジェネリクスの実体は、すべて Object 型で扱うクラスであり、
 *     利用するタイミングで型パラメータで指定された型にダウンキャストしているだけ
 * </pre>
 */