package chapter_22;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class SampleCollector implements Collector<String, StringBuilder, String> {

  /**
   * 処理途中の値を保持するためのオブジェクトを生成<br>
   */
  @Override
  public Supplier<StringBuilder> supplier() {
    return StringBuilder::new;
  }

  /**
   * 実行したい処理を記述<br>
   * - builder内が空じゃなければ、「,」と要素を追加<br>
   * - 空であれば要素のみ追加（初めて追加されるときのみ）<br>
   */
  @Override
  public BiConsumer</* 処理途中のオブジェクトの型 */StringBuilder, /* ストリーム内の要素の型 */String> accumulator() {
    return (builder, str) -> {
      if (builder.length() != 0) {
        builder.append(",");
      }
      builder.append(str);
    };
  }

  /**
   * 個々に作られた処理途中の値を保持するためのオブジェクトを結合<br>
   * - 並列処理時に有効
   */
  @Override
  public BinaryOperator<StringBuilder> combiner() {
    return (a, b) -> {
      if (a.length() != 0) {
        a.append(",");
      }
      a.append(b);
      return a;
    };
  }

  /**
   * 処理結果を戻す<br>
   */
  @Override
  public Function<StringBuilder, String> finisher() {
    return builder -> builder.toString();
  }

  /**
   * Enumセットを戻す<br>
   * - 特に列挙子を指定する必要がなければ、EnumSetクラスのnoneOfメソッドを実行<br>
   * --- Collector.characteristicsクラスのクラスリテラルを渡して、Characteristics型のからオブジェクト生成<br>
   */
  @Override
  public Set<Characteristics> characteristics() {
    return EnumSet.noneOf(Characteristics.class);
  }

}
