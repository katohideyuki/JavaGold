package chapter_16;

import java.util.Arrays;
import java.util.List;

/**
 * 汎用とコレクション<br>
 * Comparableインタフェース<br>
 */
public class SampleCompare {
  public static void main(String[] args) {
    compareExe();
  }

  /**
   * 並べ替えを行うメソッド<br>
   * - sortedの中で、compareToメソッドが呼ばれる<br>
   */
  private static void compareExe() {
    List<Item> itemList = Arrays.asList(new Item("apple", 100), new Item("banana", 50), new Item("orange", 70));
    itemList.stream().sorted().forEach(x -> System.out.println(x));
  }
}
