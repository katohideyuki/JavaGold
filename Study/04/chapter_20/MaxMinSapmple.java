package chapter_20;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * ストリームAPI<br>
 * - max/minメソッド<br>
 *
 */
public class MaxMinSapmple {
  private static List<Integer> list = Arrays.asList(98, 99, 96, 97, 95);

  public static void main(String[] args) {
    executeMax();
    executeMin();
    executeQuestion();
  }

  /**
   * listストリームに対して、maxメソッドを実行<br>
   * - ストリーム内の要素を指定されたComparetorで並べ替え、最大要素を戻す<br>
   */
  private static void executeMax() {
    System.out.println("▼ executeMaxメソッド");
    Optional<Integer> result = list.stream().max((a, b) -> Integer.compare(a, b));
    result.ifPresent(x -> System.out.println("最大要素 : " + x));
  }

  /**
   * listストリームに対して、minメソッドを実行<br>
   * - ストリーム内の要素を指定されたComparetorで並べ替え、最小要素を戻す<br>
   */
  private static void executeMin() {
    System.out.println("▼ executeMinメソッド");
    Optional<Integer> result = list.stream().min((a, b) -> Integer.compare(a, b));
    result.ifPresent(x -> System.out.println("最小要素 : " + x));
  }

  /**
   * Q.20<br>
   */
  private static void executeQuestion() {
    System.out.println("▼ executeQuestionメソッド");
    List<String> list = Arrays.asList("B", "A", "D", "C");
    Optional<String> result = list.stream().max((a, b) -> a.compareTo(b));
    result.ifPresent(x -> System.out.println(x));
  }
}
