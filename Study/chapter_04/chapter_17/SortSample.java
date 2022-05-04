package chapter_17;

import java.util.Arrays;
import java.util.List;

/**
 * ストリームAPI<br>
 * - sortedメソッド<br>
 *
 */
public class SortSample {
  public static void main(String[] a) {
    executeSample();
    executeSorted();
  }

  /**
   * String型のlistストリームに対して、sortedメソッド実行<br>
   * - ストリーム内の要素を自然順序に従って並べ替える<br>
   */
  private static void executeSample() {
    System.out.println("▼ executeSampleメソッド");

    List<String> list = Arrays.asList("A", "B", "C", "A");
    list.stream().sorted().forEach(x -> System.out.println(x));
  }

  /**
   * Item型のlistストリームに対して、sortedメソッド実行<br>
   * - 自然順序で並べ替えできないクラス<br>
   * --- その場合は、Comparator関数型で、引数を二つ受け取り整数を戻す<br>
   */
  private static void executeSorted() {
    System.out.println("▼ executeSortedメソッド");

    List<Item> list = Arrays.asList(
        new Item("A"),
        new Item("B"),
        new Item("C"),
        new Item("A")
        );
    list.stream().sorted((a, b) -> a.getName().compareTo(b.getName())).forEach(x -> System.out.println(x));
  }
}
