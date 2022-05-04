package chapter_19;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * ストリームAPI<br>
 * - reduceメソッド<br>
 *
 */
public class ReduceSample {
  private static List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

  public static void main(String[] a) {
    executeReduce();
    executeReduceProsess();
    executeArgumentReduce();
  }

  /**
   * listストリームに対して、reduceメソッドを実行<br>
   * - リスト内の要素を累積的に結合<br>
   */
  private static void executeReduce() {
    System.out.println("▼ executeReduceメソッド");
    Optional<Integer> result = list.stream().reduce((/* 累積値 */a, /* 要素 */b) -> a + b);
    result.ifPresent(x -> System.out.println(x)); // 15
  }

  /**
   * listストリームに対して、reduceメソッドを実行<br>
   * - reduceメソッドの経過を確認できるよう修正したパターン<br>
   */
  private static void executeReduceProsess() {
    System.out.println("▼ executeReduceProsessメソッド");
    Optional<Integer> result = list.stream().reduce((a, b) -> {
      int c = a + b;
      System.out.println("a = " + a); // 累積値(一番最初は先頭の要素を出力)
      System.out.println("b = " + b); // 要素
      System.out.println("a + b = " + c);
      return c;
    });
    result.ifPresent(x -> System.out.println(x));
  }

  /**
   * listストリームに対して、reduceメソッドを実行<br>
   * - reduceメソッド実行時に初期値がある場合<br>
   */
  private static void executeArgumentReduce() {
    System.out.println("▼ executeArgumentReduceメソッド");
    int result = list.stream().reduce(/* 初期値 */100, (a, b) -> {
      int c = a + b;
      System.out.println("a = " + a); // 累積値(一番最初は初期値)
      System.out.println("b = " + b); // 要素
      System.out.println("a + b = " + c);
      return c;
    });
    System.out.println(result);
  }
}
