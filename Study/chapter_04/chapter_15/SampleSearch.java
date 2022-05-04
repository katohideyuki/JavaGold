package chapter_15;

import java.util.Arrays;
import java.util.List;

/**
 * ストリームAPI<br>
 * - distinct/limit/skipメソッド<br>
 *
 */
public class SampleSearch {
  private static List<Integer> list = Arrays.asList(1, 1, 1, 1, 1, 6, 7, 8, 9, 10);

  public static void main(String[] args) {
    executeDistinct();
    executeLimit();
    executeSkip();
  }

  /**
   * listに対して、distinctメソッド実行<br>
   * - 重複を取り除き、2つ目以降の「1」が破棄される<br>
   */
  private static void executeDistinct() {
    System.out.println("▼ ditinctメソッド。重複を取り除く");
    list.stream().distinct().forEach(System.out::println);
  }

  /**
   * listに対して、limitメソッド実行<br>
   * - 引数で指定した数に、それ以外は破棄される<br>
   */
  private static void executeLimit() {
    System.out.println("▼ limitメソッド。先頭から数えて5つの要素に絞り込む");
    list.stream().limit(5).forEach(System.out::println);
  }

  /**
   * listに対して、skipメソッド実行<br>
   * - 引数で指定した数を破棄し、それ以降の要素を取り出す<br>
   */
  private static void executeSkip() {
    System.out.println("▼ skipメソッド。先頭から数えて5つの要素をすっ飛ばし、それ以降を絞り込む");
    list.stream().skip(5).forEach(System.out::println);
  }

}
