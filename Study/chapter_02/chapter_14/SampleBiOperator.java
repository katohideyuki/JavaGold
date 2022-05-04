package chapter_14;

import java.util.function.BinaryOperator;

/**
 * BinaryOperatorインターフェースの使用<br>
 *
 */
public class SampleBiOperator {
  public static void main(String[] args) {
    excuteBiOperator();

  }

  /**
   * - 第一引数に第二引数を文字連結<br>
   * - OperatorFactoryクラスを使った使用例<br>
   */
  private static void excuteBiOperator() {
    // 第一引数に第二引数を文字連結
    BinaryOperator<String> b = (str, add) -> str.concat(add);
    System.out.println(b.apply("study", " lambda"));

    // OperatorFactoryを使った処理 addメソッド(ロジックを隠蔽)
    BinaryOperator<Integer> plusResult = OperatorFactory.puls();
    System.out.println(plusResult.apply(10, 20));

    // OperatorFactoryを使った処理 minusメソッド(ロジックを隠蔽)
    BinaryOperator<Integer> minusResult = OperatorFactory.minus();
    System.out.println(minusResult.apply(10, 20));
  }

}
