package chapter_05;

import java.util.HashMap;
import java.util.function.BiConsumer;

/**
 * BiConsumerインターフェースの使用<br>
 * - 引数を２つ受け取る<br>
 * - Consumerと同じacceptメソッドを持つacceptメソッドの
 *
 */
public class Test {
  public static void main(String[] args) {
    excuteLambda();
    excuteRefernce();
  }

  /**
   * HashMapのインスタンス生成<br>
   * ラムダ式でputメソッドを呼び、HashMapのインスタンスに値をセット<br>
   * - acceptメソッドの第一引数がputのキー<br>
   * - acceptメソッドの第二引数がvalue<br>
   */
  public static void excuteLambda() {
    var map = new HashMap<String, Integer>();
    BiConsumer<String, Integer> biConsumer = (key, value) -> map.put(key, value);

    biConsumer.accept("apple", 3);
    biConsumer.accept("banana", 2);

    System.out.println(map);
  }

  /**
   * メソッド参照の場合<br>
   * - インスタンス::メソッド<br>
   * - クラス::メソッド など<br>
   */
  public static void excuteRefernce() {
    var map = new HashMap<String, Integer>();
    BiConsumer<String, Integer> biConsumer = map::put;

    biConsumer.accept("orange", 3);
    biConsumer.accept("grape", 2);

    System.out.println(map);
  }
}
