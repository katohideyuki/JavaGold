package chapter_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ストリームAPI<br>
 * - ストリームの処理順<br>
 *
 */
public class ParallelTest {
  public static void main(String[] a) {
    executeArrayList();
    executeHashSet();
  }
  /**
   * ArrayListで要素を追加した場合<br>
   * - 追加した順に管理される<br>
   */
  private static void executeArrayList() {
    System.out.println("▼ ArrayListは追加した順");
    List<String> list = Arrays.asList("D", "E", "B", "C", "A");
    list.stream().forEach(x -> System.out.println(x));
  }
  /**
   * HashSetで要素を追加した場合<br>
   * - 追加した順ではなくハッシュコードの順番で管理される<br>
   */
  private static void executeHashSet() {
    System.out.println("▼ HashSetはハッシュコード順");
    Set<String> set = new HashSet<>();
    set.add("D");
    set.add("E");
    set.add("B");
    set.add("C");
    set.add("A");
    set.stream().forEach(System.out::println);
  }
}
