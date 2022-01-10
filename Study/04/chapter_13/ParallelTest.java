package chapter_13;

import java.util.Arrays;
import java.util.List;

/**
 * ストリームAPI<br>
 * - 並列ストリーム<br>
 */
public class ParallelTest {
  private static final List<String> LIST = Arrays.asList("A", "B", "C", "D", "E");

  public static void main(String[] args) {
    executeForEach();
    executeForEachOrdered();
  }

  /**
   * parallelStreamで取り出したコレクションに対して、forEachメソッドを実行<br>
   * - 処理順が毎回バラバラになる<br>
   * --- 複数スレッドが起動し、一斉にストリームを処理しているため<br>
   */
  private static void executeForEach() {
    System.out.println("▼ 処理順はバラバラ");
    LIST.parallelStream().forEach(x -> System.out.println(x));
  }

  /**
   * parallelStreamで取り出したコレクションに対して、forEachOrderedメソッドを実行<br>
   * - コレクション順に処理される<br>
   * --- ただし、処理順を意識する分、マルチスレッドの利点であるパフォーマンス向上が見込めない<br>
   */
  private static void executeForEachOrdered() {
    System.out.println("▼ コレクション順に処理される");
    LIST.parallelStream().forEachOrdered(System.out::println);
  }
}
