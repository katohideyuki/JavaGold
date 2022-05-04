package chapter_11;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * ストリームAPI<br>
 * - プリミティブ型の配列<br>
 *
 */
public class SampleStream {
  private static final String[] ARRAY = { "A", "B", "C" };
  private static final int[] INT_ARRAY = { 1, 2, 3 };

  public static void main(String[] a) {
    executeStream();
    executeIntStream();
  }

  /**
   * String型の配列からストリームをつくる<br>
   */
  private static void executeStream() {
    Stream<String> stream = Arrays.stream(ARRAY);
  }

  /**
   * int型の配列からストリームをつくる<br>
   * - IntStream, LongStream, DoubleStream<br>
   */
  private static void executeIntStream() {
    // プリミティブ型の配列を扱うときは、Stream型ではないので注意
//    Stream<Integer> stream = Arrays.stream(INT_ARRAY);
    IntStream stream = Arrays.stream(INT_ARRAY);
  }

}
