package chapter_08;

import java.util.Optional;

/**
 * Optionalクラス<br>
 * - FlatMapメソッド<br>
 *
 */
public class FlatMapTest {
  private static final Optional<String> optional = Optional.of("test"); // 初期値

  public static void main(String[] a) {
    executeFlatMap();
  }

  /**
   * Optionalインスタンスに対して、FlatMapメソッドを実行<br>
   * - FlatMapメソッドでは、新しいOptionalインスタンスを生成せず、そのまま戻す<br>
   * --- testメソッドで返ってくるOptionalインスタンスの参照をそのまま戻すことになる<br>
   */
  private static void executeFlatMap() {
    // mapメソッドの場合、Optional<Optional<String>>がresultに代入されるが、Optional<String>型になっているため、コンパイルエラー
//    Optional<String> result = optional.map(str -> test(str));

    Optional<String> result = optional.flatMap(str -> test(str));
    System.out.println("初期値: " + optional.get());
    System.out.println("加工後: " + result.get());
  }

  /**
   * 大文字に変換する処理<br>
   *
   * @param str
   * @return 新しいOptionalインスタンスの参照を戻す
   */
  private static Optional<String> test(String str) {
    return Optional.of(str.toUpperCase());
  }
}
