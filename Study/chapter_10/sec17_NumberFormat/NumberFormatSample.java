package sec17_NumberFormat;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

import debug.Debug;

/** NumberFormat の使用例 */
public class NumberFormatSample {
    static final double NUM = 12345.6;    // フォーマットに渡す数値

    public static void main(String[] args) {
        exe();
    }

    private static void exe() {
        Debug.log("exe");
        Locale.setDefault(Locale.JAPAN);    // ロケール設定（省略可）

        // NumberFormat フォーマット名?をキーに、フォーマットの結果を値にセット
        Map<String, String> resultMap = Map.of(
                "Normal", NumberFormat.getInstance().format(NUM),
                "Integer only", NumberFormat.getIntegerInstance().format(NUM),  // 小数点以下は四捨五入
                "Currency", NumberFormat.getCurrencyInstance().format(NUM),     // 小数点以下は四捨五入され、「¥」がつく
                "Percent", NumberFormat.getPercentInstance().format(NUM)        // x100され「%」がつく
                );

        // 出力
        resultMap.keySet().stream()
        .forEach(k -> System.out.printf("%s : %s%n", k, resultMap.get(k)));
    }
}

/**
 * <pre>
 * Numberformat
 *   - 数値のフォーマットを扱う抽象クラス
 *   - フォーマットをかけた結果は、3桁区切りで「,」（カンマ）がつく
 *   - 抽象クラスなので、new を使ってインスタンス化はできない
 *   - NumberFormat.getXXXInstance メソッドには引数あり/なしがある
 *       - 引数なしのメソッドを使えば、デフォルトのロケールが使われる
 *       - 引数ありであれば、Locale インスタンスを渡し、任意のロケール情報を使う
 *
 * Numberformat.getInstance()
 *   - 通常の数値フォーマット
 *
 * Numberformat.getIntegerInstance()
 *   - 整数型数値フォーマット
 *
 * Numberformat.getCurrencyInstance()
 *   - 通過フォーマット
 *
 * Numberformat.getPercentInstance()
 *   - パーセント表記する数値フォーマット
 *
 * NumberFormat.format(数値)
 *   - format に整形した文字列を返却
 * </pre>
 */
