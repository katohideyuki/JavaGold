package practiceExam_Q46;

import java.util.List;
import java.util.stream.Collectors;

import debug.Debug;

/** Collectors.averagindDouble の使用例 */
public class Smaple {
    public static void main(String[] argas) {
        creAverage();
    }

    /*  */
    private static void creAverage() {
        Debug.log("creAverage");
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // リスト内の平均値を算出
        double a = list.stream()
                .collect(Collectors.averagingDouble(n -> n));
        System.out.println(a);    // 5.5

        // リスト内の平均値を算出
        double b = list.parallelStream()
                .mapToInt(n -> n)
                .average()
                .getAsDouble();   // average の結果、空の Optional だった場合、NoSuchElementException がスローされる
        System.out.println(b);    // 5.5
    }
}

/**
 * <pre>
 *  stream.Collectors.averagingDouble()
 *    - ストリームの要素を double 型に変換し、平均を求める
 *
 *  stream.IntStream.average()
 *    - ストリーム内の数値の平均を求め、OptionalDouble 型の結果を返却する
 *
 *  OptionalDouble.getAsDouble()
 *    -　結果の値を double 型で返却する
 *
 * </pre>
 */