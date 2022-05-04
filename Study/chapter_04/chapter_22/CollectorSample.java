package chapter_22;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * ストリームAPI<br>
 * - Collectorインターフェース Part2<br>
 */
public class CollectorSample {
  private static List<String> list = Arrays.asList("A", "B", "C", "D", "E");

  public static void main(String[] a) {
    executeCollector();
    executeParallel();
  }

  /**
   * listストリームに対して、collectメソッドを実行<br>
   * - SampleCollectorのインスタンス参照を渡す<br>
   * --- (1) ラムダ式内から、外部オブジェクトを操作していない<br>
   * --- (2) 文字列ストリームから「カンマ区切りの文字列を作る処理の再利用ができる<br>
   */
  private static void executeCollector() {
    System.out.println("▼ executeCollectorメソッド");

    String result = list.stream().collect(new SampleCollector());
    System.out.println(result); // A,B,C,D,E
  }

  /**
   * listストリームに対して、collectメソッドを並列処理として実行<br>
   * - conbinerメソッドの途中処理が加わる<br>
   * --- listストリームが並列処理され、StringBuilderも複数生成される<br>
   * --- これらを結合して一つのStringBuilderにしてからfinisherメソッドが実行される<br>
   */
  private static void executeParallel() {
    System.out.println("▼ executeParallelメソッド");

    String result = list.parallelStream().collect(new SampleCollector());
    System.out.println(result);
  }
}
