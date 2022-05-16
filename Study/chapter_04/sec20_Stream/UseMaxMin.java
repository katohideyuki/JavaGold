package sec20_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import debug.Debug;

/** Stream.max min の使用例 */
public class UseMaxMin {
    static final List<Integer> LIST = Arrays.asList(1, 2, 3, 4, 5);
    public static void main(String[] args) {
        outMax();
        outMin();
        question20();
    }
    /* リスト内の最大値を出力する - max */
    private static void outMax() {
        Debug.log("outMax");
        Optional<Integer> maxNum = LIST.stream().max((a, b) -> {
            if (a == b) return 0;
            if (a < b)  return -1;
            return 1;
        });
        maxNum.ifPresent(System.out::println);  // 5
    }

    /* リスト内の最小値を出力する - min */
    private static void outMin() {
        Debug.log("outMin");
        Optional<Integer> minNum = LIST.stream().min(Integer::compareTo);
        minNum.ifPresent(System.out::println);  // 1
    }

    /* 設問Q.20 */
    private static void question20() {
        Debug.log("question20");
        List<String> list = Arrays.asList("B", "A", "D", "C");
        Optional<String> result = list.stream().max((a, b) -> a.compareTo(b));
        result.ifPresent(str -> System.out.println(str));  // D

    }
}

/**
 * <pre>
 * Stream.max(compare メソッドに相当するラムダ式)
 *   - ストリーム内の要素を指定された Comparator で並び替え、最大の値を返却
 *
 * Stream.min(compare メソッドに相当するラムダ式)
 *   - ストリーム内の要素を指定された Comparator で並び替え、最小の値を返却
 * </pre>
 */