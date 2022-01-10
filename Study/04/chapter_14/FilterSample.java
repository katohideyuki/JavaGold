package chapter_14;

import java.util.Arrays;
import java.util.List;

/**
 * ストリームAPI<br>
 * - filterメソッド<br>
 *
 */
public class FilterSample {
  private static final List<Integer> LIST = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

  public static void main(String[] args) {
    executeFilter();
    executeFilterSecond();
  }

  /**
   * filterメソッドの使用例<br>
   * - 要素の絞り込み<br>
   * --- Predicate型の引数を受け取る<br>
   *
   */
  private static void executeFilter() {
    System.out.println("▼ 偶数のみ表示");
    LIST.stream().filter(x -> x % 2 == 0).forEach(x -> System.out.println(x));
  }

  /**
   * filterメソッドを2回実行した使用例<br>
   * - 絞り込み処理は、複数回行うことができる<br>
   */
  private static void executeFilterSecond() {
    System.out.println("▼ 6以上かつ偶数のみ表示");
    LIST.stream().filter(x -> x > 5).filter(x -> x % 2 == 0).forEach(System.out::println);
  }
}
