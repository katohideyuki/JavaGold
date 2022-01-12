package chapter_16;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * ストリームAPI<br>
 * - findAny/findFirstメソッド<br>
 *
 */
public class SampleReturn {
  private static String[] array = { "A", "B", "C" };
  private static List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

  public static void main(String[] a) {
    executeFindAny();
    executeFindFirst();
    executeFindarallel();
    executeFilter();
  }

  /**
   * arrayストリームに対して、findAnyメソッドを実行<br>
   * - 逐次処理の場合、追加された順に管理された一番先頭の要素を戻す<br>
   * - 並列処理の場合、処理順は保証されないため、ランダムとなる<br>
   */
  private static void executeFindAny() {
    System.out.println("▼ executeFindAnyメソッド");

    Optional<String> op = Arrays.stream(array).findAny();
    op.ifPresent(x -> System.out.println(x));
  }

  /**
   * arrayストリームに対して、findFirstメソッドを実行<br>
   * - いかなる時であれ、追加された順に管理された一番先頭の要素を戻す<br>
   */
  private static void executeFindFirst() {
    System.out.println("▼ executeFindFirstメソッド");

    Optional<String> op = Arrays.stream(array).findFirst();
    op.ifPresent(x -> System.out.println(x));
  }

  /**
   * 並列処理されたlistストリームに対して、findAny / findFirstメソッド実行<br>
   * - findAnyはランダム<br>
   * - findFirstは先頭の要素を戻す<br>
   */
  private static void executeFindarallel() {
    System.out.println("▼ executeFindarallelメソッド");

    list.parallelStream().findAny().ifPresent(
        x -> System.out.println("並列処理に対して、findAnyはランダムの要素となる : " + x)); // 1~5
    list.parallelStream().findFirst().ifPresent(
        x -> System.out.println("並列処理に対しても、findFirstは必ず先頭の要素となる : " + x)); // 1
  }

  /**
   * 並列処理かつfilterをかけたlistストリームに対して、findFirstメソッド実行<br>
   * - 偶数のみに絞るためfilterをかける<br>
   * ---  並列処理のため、filterメソッドで処理される順番はランダム<br>
   * - findFirstメソッドが戻すのは、filterで絞られたlistストリームの先頭の要素を戻す<br>
   */
  private static void executeFilter() {
    System.out.println("▼ executeFilterメソッド");

    // filterメソッド内で呼ばれるPredicateメソッドを改造(偶数のみに絞り込む)
    Predicate<Integer> pre = num -> {
     boolean result = num % 2 == 0;
     System.out.println(num + ": " + result);
     return result;
    };
    list.parallelStream().filter(pre).findFirst().ifPresent(x -> System.out.println(x)); // 2
  }
}
