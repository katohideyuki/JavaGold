package chapter_03;

import java.util.Optional;

/**
 *  Optionalクラス<br>
 *  - orElse/orElseGet<br>
 */
public class GetTest {
  public static void main(String[] a) {
    executeOrElse();
    executeOrElseGet();
  }

  /**
   * orElseメソッドの使用例<br>
   * - 値を持っていればその値を、空であれば引数で渡した代替値を戻す<br>
   */
  private static void executeOrElse() {
    Optional<String> optional = Optional.empty();
    System.out.println(optional.orElse("1) インスタンスが空です"));
  }

  /**
   * orElseGetメソッドの使用例<br>
   * - 値を持っていればその値を、空であればSupplier型のラムダ式を実行した結果を戻す<br>
   */
  private static void executeOrElseGet() {
    Optional<String> optional = Optional.empty();
    System.out.println(optional.orElseGet(() -> "2) インスタンスが空です"));
  }
}
