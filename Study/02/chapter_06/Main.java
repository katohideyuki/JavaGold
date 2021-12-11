package chapter_06;

import java.util.function.Predicate;

/**
 * Predicateインターフェースの使用<br>
 * - 引数を１つ受け取り、判定を行い、結果をboolean型で戻す<br>
 * - testメソッドを持つ<br>
 *
 */
public class Main {
  public static void main(String[] args) {
    excuteTest();
  }

  /**
   * testメソッドで受け取った文字列が空かどうか判定<br>
   * - isEmptyメソッド<br>
   * -- 空ならTrue<br>
   */
  public static void excuteTest() {
    Predicate<String> predicate = (string) -> string.isEmpty();
    System.out.println("isEmptyメソッドの結果：" + predicate.test(""));
  }
}
