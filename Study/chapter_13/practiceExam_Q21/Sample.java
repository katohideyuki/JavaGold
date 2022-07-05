package practiceExam_Q21;

import java.util.List;
import java.util.Optional;

import debug.Debug;

/** Optional.ifPresent の使用例 */
public class Sample {
    public static void main(String[] argas) {
        useReduce();
    }

    private static void useReduce() {
        Debug.log("useReduce");
        var list = List.of(
                "apple",
                "banana",
                "orange",
                "melon"
                );

        // list 内で"z"文字列のみにフィルタリングし、文字列を結合
        Optional<String> result = list.stream()
                .filter(x -> x.contains("z"))
                .reduce((i, j) -> i + ", " + j);

        // フィルタリングした結果を出力 - 何も出力されない
        result.ifPresent(System.out::println);
    }
}

/**
 * <pre>
 * Optional.ifPresent()
 *   - 結果が存在すれば、渡された Consumer 型の処理を実行し、
 *     結果が存在しなければ何もしない
 *
 * Stream.reduce()
 *   - 何も渡されなければ、空の Optional を返却する
 * </pre>
 */