package chapter_11;

import java.util.function.BiFunction;

/**
 * BiFunctionインターフェースの使用<br>
 *
 */
public class SampleBiFunction {
  public static void main(String[] args) {
    excuteBiFunction();
  }

  /**
   * String型の引数を二つ渡し、String型で返ってくる<br>
   * - 第一引数の文字列に、第二引数の文字列を結合<br>
   */
  private static void excuteBiFunction() {
    BiFunction<String, String, String> biFunction = (firstStr, secondStr) -> firstStr.concat(secondStr);

    System.out.println(biFunction.apply("第一引数の文字列 : ", "第二引数の文字列"));
  }
}
