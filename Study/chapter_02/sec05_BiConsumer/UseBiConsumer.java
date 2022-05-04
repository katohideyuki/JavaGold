package sec05_BiConsumer;

import java.util.HashMap;
import java.util.function.BiConsumer;

/** BiConsumer インターフェースの使用例 */
public class UseBiConsumer {
  public static void main(String[] args) {
    creMap();
    creMapBestPractice();
  }

  /* HashMap のインスタンスを生成
       - ラムダ式で put メソッドを呼び、HashMap インスタンスに値をセット */
  private static void creMap() {
    var map = new HashMap<String, Integer>();
    BiConsumer<String, Integer> bi = (key, val) -> map.put(key, val);

    bi.accept("apple", 3);
    bi.accept("orange", 2);

    System.out.println(map);
  }

  /* HashMap のインスタンスを生成 - メソッド参照 */
  private static void creMapBestPractice() {
    var map = new HashMap<String, Integer>();
    BiConsumer<String, Integer> bi = map::put;

    bi.accept("banana", 3);
    bi.accept("peach", 2);

    System.out.println(map);
  }
}

/**
 * <pre>
 * BiConsumer<T, U>
 *   - 引数を二つ受け取る
 *
 * メソッド参照
 *   - インスタンス::メソッド
 *   - クラス::メソッド
 *
 * メソッド参照は、たいていラムダよりも簡潔に記述できる
 *   - メソッド参照の方が短く明瞭であるならば、メソッド参照を使う
 *   - そうでないなら、ラムダを使う
 * </pre>
 */