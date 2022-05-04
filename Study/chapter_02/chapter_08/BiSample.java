package chapter_08;

import java.util.function.BiPredicate;

/**
 * BiPredicateインターフェース
＠FunctionInterface
public interface BiPredicate<T, U> {
  boolean test(T, U);
}
*/

/**
 * BiPredicateインターフェースの使用
 * - 型パラメータを二つ指定
 *    - 引数を2つ受け取る
 * - testメソッドを持つ
 *
 */
public class BiSample {
  public static void main(String[] args) {
    excuteBiPredicate();
  }

  /**
   * 第一引数が、第二引数の文字列で終わっていればtrue
   */
  private static void excuteBiPredicate() {
    BiPredicate<String, String> bi = (str, suffix) -> str.endsWith(suffix);
    System.out.println(bi.test("smaple.class", ".class")); // true
  }

}
