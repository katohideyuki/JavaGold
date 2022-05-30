package sec03_TypeInference;

import java.util.ArrayList;
import java.util.List;

import debug.Debug;

/** 型推論の使用例 */
public class UseTypeInference {
    public static void main(String[] args) {
        howToTypeInference();
    }

    /* 型推論が使える主な箇所 */
    private static void howToTypeInference() {
        Debug.log("howToTypeInference");
        List<String> list = new ArrayList<>();  // 変数への代入
        sampleExe(new ArrayList<>());           // メソッド呼び出しの引数

    }

    /*　メソッドの戻りを型推論する */
    private static List<String> sampleExe(List<String> list) {
        System.out.println(list);
        return new ArrayList<>();               // メソッドの戻り値
    }
}

/**
 * <pre>
 * 型推論
 *   - コンストラクタ使用時の型パラメータを推論する
 *   - ダイヤモンド演算子「<>」を記述するだけ
 *     - 型推論の使用箇所
 *       - 変数への代入
 *       - メソッドの戻り値
 *       - メソッド呼び出しの引数
 * </pre>
 */