package chapter_09;

import java.util.List;

/**
 * ストリームAPI<br>
 * - forEachメソッド<br>
 */
public class Sample {
  private static final List<Integer> LIST = List.of(1, 2, 3, 4, 5);

  public static void main(String[] a) {
    executeOldFor();
    executeNewFor();
  }

  /**
   * 拡張for文を使った要素の取り出し<br>
   */
  private static void executeOldFor() {
    System.out.println("▼ executeOldForメソッド");

    for (Integer num : LIST) {
      System.out.println(num);
    }
  }

  /**
   * forEachを使った要素の取り出し<br>
   * - 要素を順番に取り出しながら、引数に渡されたConsumer型のラムダ式を実行<br>
   */
  private static void executeNewFor() {
    System.out.println("▼ executeNewForメソッド");

    LIST.forEach(x -> System.out.println(x));
    System.out.println("----------------------");
    LIST.forEach(System.out::println); // おまけ: この程度であればメソッド参照の方が簡易
  }
}
