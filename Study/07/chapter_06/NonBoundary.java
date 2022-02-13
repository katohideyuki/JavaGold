package chapter_06;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 汎用とコレクション<br>
 * 非境界ワイルドカード「？」を使用<br>
 */
public class NonBoundary {
  private static final List<String> STRING_LIST = Arrays.asList("A", "B", "C");
  private static final List<Integer> INT_LIST = Arrays.asList(1, 2, 3, 4, 5);

  public static void main(String[] args) {
    printAll(STRING_LIST);
    printAll(INT_LIST);
  }

  /**
   * どんな型であれCollection型であれば使えるメソッド<br>
   * - ジェネリクスに「?」と定義することで可能となる<br>
   * @param collection
   */
  private static void printAll(Collection<?> collection) {
    collection.stream().forEach(x -> System.out.println(x));
  }

}
