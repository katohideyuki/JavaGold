package chapter_28;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * ストリームAPI<br>
 * - 2つの終端操作を実行し、IllegalStateException<br>
 *
 */
public class SampleNgCall {
  public static void main(String[] a) {
    executeNgCall();
  }

  /**
   * listストリームに対して、2回終端操作メソッドを呼び出す<br>
   * - 終端操作を実行すると、ストリーム・パイプラインは終了する<br>
   * - 2回目の呼び出し時に異常な状態を表すIllegalStateException発生<br>
   */
  private static void executeNgCall() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    Stream<Integer> stream = list.stream();

    try {
      System.out.println(stream.count()); // 1回目の終端操作countメソッド
      stream.forEach(x -> System.out.println(x)); // 2回目の終端操作forEachメソッド：例外発生
    } catch (IllegalStateException e) {
      e.printStackTrace();
    }

  }

}
