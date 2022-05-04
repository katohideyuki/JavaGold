package chapter_12;

import java.util.function.UnaryOperator;

/**
 * UnaryOperatorインターフェースの使用<br>
 *
 */
public class SampleUnaryOperator {
  public static void main(String[] args) {
    excuteUnaryOperator();
  }

  /**
   * 引数をインクリメント<br>
   * 引数を2倍<br>
   */
  private static void excuteUnaryOperator() {
    UnaryOperator<Integer> uo = x -> ++x;
    System.out.println(uo.apply(10)); // 11

    UnaryOperator<Integer> uoSecond = x -> x * 2;
    System.out.println(uoSecond.apply(10)); // 20
  }
}
