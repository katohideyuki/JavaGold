package sec15_MapEntry;

import java.util.Map.Entry;
import static java.util.Map.entry;
import static java.util.Map.ofEntries;
import java.util.HashMap;
import java.util.Map;

import debug.Debug;

/** Map.Entry の使用例 */
public class UseMapEntry {
    public static void main(String[] args) {
        useEntry();
        question15();
    }

    /* Map から Map.Entry の集合を取得して、出力する */
    private static void useEntry() {
        Debug.log("useEntry");
        Map<String, Integer> map = new HashMap<>();
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THREE", 3);
        // map から Map.Entry の集合を取得し、続けてキーと値を取得
        map.entrySet().stream().forEach(entry -> {
            System.out.printf("%s : %s%n", entry.getKey(), entry.getValue());
        });
    }

    /* 設問15 */
    private static void question15() {
        Debug.log("question15");
        var a = entry(1, "A");
        var b = entry(2, "B");
        var c = entry(3, "C");
        // Map.ofEntries で Entry インスタンスの Map を生成
        Map<Integer, String> map = ofEntries(a, b, c);
        // Map.entrySet で Entry の集合を取得し、続けてキーと値を取得
        for (Entry<Integer, String> entry : map.entrySet())
            System.out.printf("%s : %s%n", entry.getKey(), entry.getValue());
    }
}

/**
 * <pre>
 * Map.Entry
 *   - Map インタフェース内に定義されたインナーインタフェース
 *   - ペア = Map.Entry
 *     - [キー, 値] = 一つの Map.Entry というイメージ
 *
 * Map.entrySet()
 *   - Map.Entry の集合を取得
 *
 * Map.Entry.getKey()
 *   - ペアのキーを取得
 *
 * Map.Enrty.getValue()
 *   - ペアの値を取得
 *
 * Map.entry(キー, 値)
 *   - static なメソッド
 *   - このメソッドで生成された Map.Entry オブジェクトは Immutable(変更不可)
 *
 * Map.ofEntries(entry(キー1, 値1), entry(キー2, 値2)...) ※ sec14 の補足
 *   - Immutable(変更不可)な Map を返却
 * </pre>
 */
