package chapter_21;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * ストリームAPI<br>
 * - Collectorインターフェース Part1<br>
 * - ストリーム文字列を繰り返す<br>
 * - [問題]
 * --- (1) ラムダ式内から、外部オブジェクトを操作している<br>
 * --- (2) 文字列ストリームから「カンマ区切りの文字列を作る処理を行いたくても再利用できない<br>
 */
public class CollectorSample {
  private static List<String> list = Arrays.asList("A", "B", "C", "D", "E");

  public static void main(String[] a) {
    executeCollector();
    executeTest();
  }

  /**
   * ダメな例<br>
   * listストリームに対して、forEachメソッドを実行<br>
   * - 実行時にbuilderオブジェクトの値を変更(1に該当)<br>
   * - 再利用できない(2に該当)<br>
   */
  private static void executeCollector() {
    System.out.println("▼ executeCollectorメソッド");

    StringBuilder builder = new StringBuilder();
    list.stream().forEach(x -> {
      if (builder.length() != 0) {
        builder.append(","); // 副作用
      }
      builder.append(x); // 副作用
    });
    System.out.println(builder); // A,B,C,D,E
  }

  /**
   * 2だけ解消された例<br>
   * listストリームに対して、forEachメソッドを実行<br>
   * - 実行時にbuilderオブジェクトの値を変更(1に該当)<br>
   * - 再利用できる<br>
   * --- 処理内容を記述したConsumer型のラムダ式を用意(forEachメソッド外に記述)<br>
   */
  private static void executeTest() {
    System.out.println("▼ executeTestメソッド");

    StringBuilder builder = new StringBuilder();
    Consumer<String> c = x -> {
      if (builder.length() != 0) {
        builder.append(",");
      }
      builder.append(x);
    };
    list.stream().forEach(c);
    System.out.println(builder);
  }

}
