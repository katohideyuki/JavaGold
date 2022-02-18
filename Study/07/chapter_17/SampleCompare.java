package chapter_17;

import java.util.Arrays;
import java.util.List;

/**
 * 汎用とコレクション<br>
 * Comparetorインタフェース/compareメソッド<br>
 */
public class SampleCompare {
  public static void main(String[] a) {
    compareExe();
  }

  /**
   * sorted内で比較対象を受け取り、ItemクラスのCompareToメソッドを呼び出す<br>
   * - 比較対象を2つ受け取っているため、compareメソッドのような処理を行っている<br>
   * compareメソッド<br>
   * - 2つの比較対象の引数を受け取り、比較する<br>
   */
  private static void compareExe() {
    List<Items> itemsList = Arrays.asList(new Items("apple", 50), new Items("orange", 100), new Items("banana", 80));
    itemsList.stream().sorted((o1, o2) -> {
      return o1.getName().compareTo(o2.getName());
    }).forEach(x -> System.out.println(x));
  }
}
