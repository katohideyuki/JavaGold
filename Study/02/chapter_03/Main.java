package chapter_03;

import java.util.function.Consumer;

public class Main {
  public static void main(String[] args) {
    lamdaConsumer();
  }

  /**
   * 戻り値は戻さず、単一の引数を受け取り、その引数を使った処理を実行する<br>
   * - acceptメソッド<br>
   * <br>
   * https://docs.oracle.com/javase/jp/8/docs/api/java/util/function/Consumer.html<br>
   */
  public static void lamdaConsumer() {

    Consumer<String> consumer = x -> System.out.println(x);
    consumer.accept("acceptメソッドが受け取る引数");

  }

}
