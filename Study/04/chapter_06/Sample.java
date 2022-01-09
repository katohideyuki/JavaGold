package chapter_06;

import java.util.Optional;

/**
 * Optionalクラス<br>
 * - ifPresentOrElseメソッド<br>
 */
public class Sample {
  public static void main(String[] a) {
    execute();
    executeIfPresentOrElse();
  }

  /**
   * 値を保持したOptionalインスタンスに対して、ifPresentOrElseメソッドを実行<br>
   * - 値があれば、第一引数のConsumer型のラムダ式が実行される<br>
   */
  private static void execute() {
    System.out.println("▼ executeメソッド");

    Optional<String> optional = Optional.ofNullable("sample");
    optional.ifPresentOrElse(/* Consumer */(str) -> System.out.println("値あり: " + str),
        /* Runnable */() -> System.out.println("値なし:" + optional));
  }

  /**
   * 空のOptionalインスタンスに対して、ifPresentOrElseメソッドを実行<br>
   * - 空であれば、第二引数のRunnable型のラムダ式が実行される<br>
   */
  private static void executeIfPresentOrElse() {
    System.out.println("▼ executeIfPresentOrElse");

    Optional<String> optional = Optional.empty();
    optional.ifPresentOrElse(/* Consumer */(str) -> System.out.println("値あり: " + str),
        /* Runnable */() -> System.out.println("値なし: " + optional));
  }
}
