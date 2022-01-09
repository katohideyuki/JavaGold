package chapter_05;

import java.util.Optional;

/**
 * Optionalクラス<br>
 * - ifPresentメソッド<br>
 *
 */
public class Sample {
  public static void main(String[] a) {
    executeIfPresent();
    execute();
  }

  /**
   * 値を保持したOptionalインスタンスに対して、ifPresentメソッドを実行<br>
   * - 値があればConsumer型のラムダ式が実行される<br>
   */
  private static void executeIfPresent() {
    Optional<String> optional = Optional.of("1) 値を保持");
    optional.ifPresent((str) -> System.out.println(str));
  }

  /**
   * 空のOptionalインスタンスに対して、ifPresentメソッドを実行<br>
   * - 空なのでConsumer型のラムダ式は実行されない<br>
   */
  private static void execute() {
    Optional<String> optional = Optional.empty();
    optional.ifPresent((str) -> System.out.println(str));
  }
}
