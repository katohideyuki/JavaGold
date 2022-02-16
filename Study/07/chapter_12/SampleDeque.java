package chapter_12;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 汎用とコレクション<br>
 * Dequeインターフェース<br>
 */
public class SampleDeque {
  public static void main(String[] args) {
    dequeExe();
  }

  /**
   * Dequeコレクション<br>
   * - 先頭or末尾から追加できる<br>
   * - 取り出される時は先頭から<br>
   */
  private static void dequeExe() {
    Deque<String> deque = new ArrayDeque<>();
    deque.addLast("A");
    deque.addLast("B");
    deque.addFirst("C");
    deque.addFirst("D");
    deque.stream().forEach(x -> System.out.println(x)); // D, C ,B ,A
  }
}
