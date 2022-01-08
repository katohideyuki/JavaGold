package chapter_01;

import java.util.Optional;

/**
 * Optionalクラスのメソッド使用例<br>
 * - emptyメソッド<br>
 * - ofメソッド<br>
 * - ofNullableメソッド<br>
 */
public class OfTest {
  public static void main(String[] a) {
    executeEmpty();
    executeOf();
    executeOfNull();
  }

  /**
   * Optional.emptyメソッド<br>
   * - 空のOptionalインスタンスの参照を戻す<br>
   */
  private static void executeEmpty() {
    System.out.println("▼ Optional.emptyメソッド");

    Optional<String> optional = Optional.empty();
    System.out.println(optional);
  }

  /**
   * Optional.ofメソッド<br>
   * - null以外の値を持ったOptionalインスタンスの参照を戻す<br>
   * - null 非許容<br>
   */
  private static void executeOf() {
    System.out.println("▼ Optional.ofメソッド");
    try {
      Optional<String> optional = Optional.of(null);
      System.out.println(optional);
    } catch (NullPointerException e) {
      System.out.println(e);
    }
  }

  /**
   * Optional.ofNullableメソッド<br>
   * - null以外の値を持ったOptionalインスタンスの参照を戻す<br>
   * - nullであれば空のOptionalインスタンスの参照を戻す<br>
   *
   */
  private static void executeOfNull() {
    System.out.println("▼ Optional.ofNullableメソッド");

    Optional<String> optional = Optional.ofNullable(null);
    System.out.println(optional);
  }

}
