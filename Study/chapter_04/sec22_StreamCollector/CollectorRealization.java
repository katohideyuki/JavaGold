package sec22_StreamCollector;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/** Collector インターフェースの使用例 */
public class CollectorRealization implements Collector<String, StringBuilder, String> {

    @Override /* 処理途中の値を保持するためのオブジェクトを生成 */
    public Supplier<StringBuilder> supplier() {
        return StringBuilder::new;
    }

    @Override /* 実行したい処理を記述 */
    public BiConsumer<StringBuilder, String> accumulator() {
        return (builder, str) -> {
            // builder が空じゃなければ「,」を追加し、その後ろに文字列を追加する
            if (builder.length() != 0)
                builder.append(", ");
            builder.append(str);
        };
    }

    @Override /* 並列処理時、個々に作られた処理途中の値を保持するためのオブジェクトを結合
                   - 並列処理時の実行したい処理を記述 (accumulator と同じ処理) */
    public BinaryOperator<StringBuilder> combiner() {
        return (builder, str) -> {
            // // builder が空じゃなければ「,」を追加し、その後ろに文字列を追加する
            if (builder.length() != 0)
                builder.append(", ");
            builder.append(str);
            return builder;
        };
    }

    @Override /* 処理結果を返却 - StringBuilder 型を受け取り、String 型を返却 */
    public Function<StringBuilder, String> finisher() {
        return builder -> builder.toString();
    }

    @Override /* Enum セットを返却 */
    public Set<Characteristics> characteristics() {
        return EnumSet.noneOf(Characteristics.class);
    }
}

/**
 * Collector.supplier()
 *   - 処理途中の値を保持するためのオブジェクトを生成
 *   - 戻り値にSupplier型のラムダ式を返却
 *
 * Collector.accumlator()
 *   - 具体的に実行したい処理を記述した BiConsumer 型のラムダ式を返却
 *
 * Collector.combiner()
 *   - 並列処理時、個々に作られた処理途中の値を保持するためのオブジェクトを結合
 *   - accumulator の並列処理バージョン
 *
 * Collector.finisher()
 *   - 処理結果を返却するラムダ式を提供する
 *
 * Collector.characteristrics()
 *   - Collector の特徴を表す Enum のセットを返却
 *     - CONCURRENT     : この Collector が並行処理することを表す
 *     - IDENTTY_FINISH : この Collector の finisher メソッドが省略可能であることを表す
 *     - UNORDERED      : コレクション操作において、順序の維持を保証しないことを表す
 *
 *   - 上記のような列挙子を指定する必要がなければ、EnumSet.noneOf(characteristrics.class) を実行
 *     - Collector 型を扱う空の Set オブジェクトが生成される
 */