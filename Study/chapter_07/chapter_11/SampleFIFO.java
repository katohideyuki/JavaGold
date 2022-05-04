package chapter_11;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 汎用とコレクション<br>
 * Queueインターフェース<br>
 */
public class SampleFIFO {
  public static void main(String[] a) {
    queueExe();
  }

  /**
   * Queueコレクション<br>
   * - 最初に格納した要素を最初に取り出す<br>
   * - 一度取り出された値はもうQueue型には保持されないので、もう一度pollメソッドを使うと次のデータが取得される<br>
   */
  private static void queueExe() {
    Queue<String> queue = new ArrayDeque<>(5);
    queue.add("A");
    queue.add("B");
    queue.add("C");
    queue.add("D");
    queue.add("E");

    queue.stream().forEach(x -> System.out.println(x));

    System.out.printf("一番先頭である%sが取り出されます。%n", queue.poll());
    System.out.printf("もう一度取り出した時は、Aではなく%sが取り出される。%n", queue.poll());
  }


}
