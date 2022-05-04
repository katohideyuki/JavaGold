package chapter_02;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Optional.getメソッドの使用例<br>
 * - isPresentメソッド<br>
 * - isEmptyメソッド<br>
 */
public class GetTest {
  public static void main(String[] a) {
    executeOfGet();
    executeEmptyGet();
    executeIsPresent();
    executeIsEmpty();
  }

  /**
   * 値を持っているOptionalインスタンスに対して、getメソッド実行<br>
   */
  private static void executeOfGet() {
    Optional<String> optional = Optional.of("1) ofメソッド");
    System.out.println(optional.get());
  }

  /**
   * 空のOptionalインスタンスに対して、getメソッド実行<br>
   * - NoSuchElementException発生<br>
   */
  private static void executeEmptyGet() {
    Optional<String> optional = Optional.empty();
    try {
      System.out.println(optional.get()); // 例外発生
    } catch (NoSuchElementException e) {
      System.out.println("2) " + e);
    }
  }

  /**
   * Optionalインスタンスに対して、isPresentメソッドを実行<br>
   * - 何かしら値を保持していればtrue<br>
   */
  private static void executeIsPresent() {
    Optional<String> optional = Optional.of("ofメソッド");
    if (optional.isPresent()) {
      System.out.println("3) 値あり: " + optional.get());
    } else {
      System.out.println("3) 値なし: " + optional);
    }
  }

  /**
   * Optionalインスタンスに対して、isEmptyメソッドを実行<br>
   * - 空であればtrue<br>
   */
  private static void executeIsEmpty() {
    Optional<String> optional = Optional.empty();
    if (optional.isEmpty()) {
      System.out.println("4) 値なし: " + optional);
    } else {
      System.out.println("4) 値あり: " + optional);
    }
  }
}
