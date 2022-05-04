package sec03_Consumer;

import java.util.function.Consumer;

/** Consumer インターフェースの使用例 */
public class LambdaConsumer {
  public static void main(String[] args) {
    useConsumer();
  }

  /* accept と andThen メソッド */
  private static void useConsumer() {
    // accept
    Consumer<String> consumer = System.out::println;
    consumer.accept("Hello, Lambda!");
    // andThen
    Consumer<String> one   = str -> System.out.printf("one called -> %s%n", str);
    Consumer<String> two   = str -> System.out.printf("two called -> %s%n", str);
    Consumer<String> three = str -> System.out.printf("three called -> %s%n", str);
    one.andThen(two).andThen(three).accept("Hello, Consumer!");
  }
}

/**
 * <pre>
 * Consumer.accept()
 *   - 戻り値は戻さず、単一の引数を受け取り、その引数を使った処理を実行する
 *
 * Consumer.andThen()
 *   - Consumerを繋げて左辺から順に処理を実行する
 * </pre>
 */
