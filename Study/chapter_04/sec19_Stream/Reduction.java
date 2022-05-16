package sec19_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import debug.Debug;

/** Stream.reduce の使用例 */
public class Reduction {
    static final List<Integer> LIST = Arrays.asList(1, 2, 3, 4, 5);

    public static void main(String[] args) {
        comulativeNotInitialVal();
        comulativeInitialVal();
    }

    /* リスト内の要素を累積的に結合する - 初期値がない場合、戻り値型はOptional */
    private static void comulativeNotInitialVal() {
        Debug.log("comulative");
        Optional<Integer> result = LIST.stream().reduce(Integer::sum);
        result.ifPresent(System.out::println);  // 15
    }

    /* リスト内の要素を累積的に結合する - 初期値がある場合、戻り値型はその初期値の型となる */
    private static void comulativeInitialVal() {
        Debug.log("comulativeInitialVal");
        int result = LIST.stream().reduce(100, Integer::sum);
        System.out.println(result);  // 115

    }
}

/**
 * <pre>
 * Stream.reduce(BinaryOperator 型ラムダ式)
 *   - 値を累積的に結合していく
 *   - 初期値がない場合の戻り値型は Optional
 *   - 初期値がある場合は、第一引数に設定する
 *     - 初期値がある場合の戻り値型は、初期値に設定した型となる
 * </pre>
 */