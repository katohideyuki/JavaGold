package chapter_10;

import java.util.function.Function;

/**
 * Functionインターフェースの使用<br>
 * - andThenメソッド<br>
 * - composeメソッド<br>
 *
 */
public class SampleFunction {
  public static void main(String[] args) {
    excuteAndThen();
    excuteCompose();
  }

  /**
   * andThenメソッド<br>
   * - applyメソッドが実行され、firstの処理。そのあとにsecondの処理<br>
   * - andThenメソッドで合成したオブジェクトを戻す<br>
   * - その新しく合成されたオブジェクトのapplyメソッドを実行<br>
   */
  private static void excuteAndThen() {
    Function<Integer, Integer> first = f -> f + 2; // 最初に処理
    Function<Integer, Integer> second = s -> s * 4; // 後の処理

    System.out.println(first.andThen(second).apply(10)); // 48
    System.out.println(second.andThen(first).apply(10)); // 42
  }

  /**
   * composeメソッド<br>
   * - applyメソッドが実行され、secondの処理。そのあとにfirstの処理<br>
   */
  private static void excuteCompose() {
    Function<Integer, Integer> first = f -> f + 2;
    Function<Integer, Integer> second = s -> s * 4;

    System.out.println(first.compose(second).apply(10)); // 42
    System.out.println(second.compose(first).apply(10)); // 48

  }
}
