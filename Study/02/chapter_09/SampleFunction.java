package chapter_09;

import java.util.function.Function;

/**
 * Functionインターフェースの使用<br>
 */
public class SampleFunction {
  public static void main(String[] args) {
    excuteFunction();
  }

  /**
   * String型の引数を渡し、Integer型で返ってくる<br>
   */
  private static void excuteFunction() {
    Function<String, Integer> function = f -> f.length();
    System.out.println(function.apply("受け取った文字列の文字数を返す"));

  }

}
