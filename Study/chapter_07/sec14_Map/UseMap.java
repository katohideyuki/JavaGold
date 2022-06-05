package sec14_Map;

import static java.util.Map.entry;
import java.util.HashMap;
import java.util.Map;

import debug.Debug;

/** Map の使用例 */
public class UseMap {
    public static void main(String[] args) {
        geInOrder();
        getInNoParticularOrder();
    }

    /* Map コレクションの値を出力 - 追加した順に要素を扱う */
    private static void geInOrder() {
        Debug.log("geInOrder");
        Map<String, Integer> map = new HashMap<>();
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THREE", 3);
        // key だけのストリームをつくり、get メソッドで値を取得
        map.keySet().stream().forEach(key -> {
            System.out.printf("%s : %s%n", key, map.get(key));
        });
    }

    /* Map コレクションの値を出力 - 順不同で要素を扱う */
    private static void getInNoParticularOrder() {
        // Map.of
        Debug.log("getInNoParticularOrder - Map.of ");
        Map<String, Integer> map = Map.of("ONE", 1, "TWO", 2, "THREE", 3);
        map.keySet().stream().forEach(key -> {
            System.out.printf("%s : %s%n", key, map.get(key));
        });
        // Map.ofEntries
        Debug.log("getInNoParticularOrder - Map.ofEntries ");
        Map<String, Integer> map2 = Map.ofEntries(
                entry("ONE", 1), entry("TWO", 2), entry("THREE", 3));
        map2.keySet().stream().forEach(key -> {
            System.out.printf("%s : %s%n", key, map.get(key));
        });
    }
}
/**
 * <pre>
 * Map
 *   - 一意なキーと、そのキーに紐付けられた値のペアを要素として扱うデータ構造
 *
 * Map.put(キー, 値)
 *   - キーと値の2つの引数を渡してペアを作る
 *
 * Map.get(キー)
 *   - キーを渡して、値を取得する
 *
 * Map.keySet()
 *   - キーだけのストリームをつくる
 *
 * Map.of(キー1, 値1, キー2, 値2...)
 *   - 宣言と代入を同時に行う
 *     - 引数の上限は10要素まで
 *     - 順序を保証しない
 *
 * Map.ofEntries(entry(キー1, 値1), entry(キー2, 値2)...)
 *   - 宣言と代入を同時に行う
 *     - static java.util.Map.entry をインポートすること ※ 自動インポートされなかったので
 *     - 順序を保証しない
 * </pre>
 */
