package chapter_07;

import java.util.Optional;

/**
 * Optionalクラス<br>
 * - mapメソッド<br>
 *
 */
public class MapTest {
  private static final Optional<String> optional = Optional.of("abcdefg");  // 初期値

  public static void main(String[] a) {
    executeOldMap();
    executeNewMap();
  }

  /**
   * getメソッドで値を取り出してから加工する<br>
   */
  private static void executeOldMap() {
    System.out.println("▼ executeOldMap ----------------");

    Optional<String> result = null;
    if (optional.isPresent()) {
      String str = optional.get();
      result = Optional.ofNullable(str.toUpperCase());
    }
    System.out.println("初期値: " + optional.get());
    System.out.println("加工後: " + result.get());
  }

  /**
   * Optionalインスタンスに対して、mapメソッドを実行<br>
   * - 値があれば、値を加工しながら取り出す<br>
   * - 空であれば、空のOptionalインスタンスの参照を戻す<br>
   *
   */
  private static void executeNewMap() {
    System.out.println("▼ executeNewMap ----------------");

    // 値あり
    Optional<String> result = optional.map(String -> String.toUpperCase());
    System.out.println("初期値: " + optional.get());
    System.out.println("値あり: " + result.get());

    // 値なし
    Optional<String> none = Optional.empty();
    Optional<String> resultNone = none.map(str -> str.toUpperCase());
    System.out.println("初期値: " + none); // 非検査例外が発生するので、インスタンスを出力
    System.out.println("値なし: " + resultNone); // 非検査例外が発生するので、インスタンスを出力
  }
}
