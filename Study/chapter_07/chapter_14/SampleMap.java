package chapter_14;

import static java.util.Map.entry;

import java.util.Map;

/**
 * 汎用とコレクション<br>
 * Mapインターフェース<br>
 */
public class SampleMap {
  public static void main(String[] a) {
    keyGet();
  }

  /**
   * Mapコレクション<br>
   * - ofEntriesメソッド<br>
   * --- 順序を保証しない<br>
   * - Map.ofメソッド<br>
   * --- 順序を保証しない<br>
   * --- 引数の上限は10コ<br>
   */
  private static void keyGet() {
    Map<String, Integer> map = Map.ofEntries(entry("one", 1), entry("two", 2), entry("three", 3));
    System.out.println("ofEntries-----------------");
    map.keySet().stream().forEach(x -> System.out.println(map.get(x)));

    // Map.of 引数の上限は10コ
    Map<String, Integer> mapOf = Map.of("a", 1, "b", 2, "c", 3, "d", 4, "f", 5, "g", 6, "h", 7, "i", 8, "j", 9, "k",
        10);
    System.out.println("map.of-----------------");
    mapOf.keySet().stream().forEach(x -> System.out.println(mapOf.get(x)));
  }
}
