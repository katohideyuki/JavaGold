package chapter_14;

import java.util.function.BinaryOperator;

/**
 * 関数型インターフェースだけ扱えるクラス<br>
 * - addメソッド<br>
 * - minusメソッド<br>
 *
 */
public class OperatorFactory {

  /**
   * @return 加算された合計<br>
   */
  public static BinaryOperator<Integer> puls() {
    return (a, b) -> a + b;
  }

  /**
   * @retur 減算された合計<br>
   */
  public static BinaryOperator<Integer> minus() {
    return (a, b) -> a - b;
  }

}
