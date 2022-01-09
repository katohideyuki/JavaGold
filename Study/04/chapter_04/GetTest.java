package chapter_04;

import java.util.Optional;

/**
 * Optionalクラス<br>
 * - orElseThrowメソッド<br>
 *
 */
public class GetTest {
  public static void main(String[] a) {
    executeOrElseThrow();
    execute();
  }

  /**
   * 空のOptionalインスタンスに対して、orElseThrowメソッドを実行<br>
   * - 空であれば、意図的に任意の検査例外を発生させる<br>
   */
  private static void executeOrElseThrow() {
    Optional<String> optional = Optional.empty();
    try {
      System.out.println(optional.orElseThrow(() -> new Exception())); // 例外発生
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 値を保持したOptionalインスタンスに対して、orElseThrowメソッドを実行<br>
   * - 値を保持しているので、例外発生しない<br>
   */
  private static void execute() {
    Optional<String> optional = Optional.of("2) 値があるので、任意の例外は発生しない。");
    try {
      System.out.println(optional.orElseThrow(() -> new Exception()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
