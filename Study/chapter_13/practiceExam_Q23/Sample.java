package practiceExam_Q23;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import debug.Debug;

/** Stream.flatMapToInt の使用例 */
public class Sample {
    public static void main(String[] args) {
        useFlatMapToInt();
    }

    private static void useFlatMapToInt() {
        Debug.log("useFlatMapToInt");

        // 2次元配列
        int array[][] = {{1, 2}, {3, 4}, {5, 6}};

        // IntStreamに変換したあと、2次元配列内の各要素を2倍した上で、
        // 3の約数にフィルタリングした要素数をカウントする
        long count = Stream.of(array)
                .flatMapToInt(IntStream::of)
                .map(n -> n * 2)
                .peek(System.out::print)
                .filter(n -> (n % 3 == 0))
                .count();

        System.out.printf(" %s", count);  // 24681012 2
    }
}

/**
 * <pre>
 * Stream.flatMapToInt()
 *   - IntStream 型のストリームに変換し、多重配列を一次元にする
 * </pre>
 */
