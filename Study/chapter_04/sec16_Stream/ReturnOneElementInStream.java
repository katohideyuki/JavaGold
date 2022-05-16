package sec16_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import debug.Debug;

/** ストリーム内の要素を一つ戻すための終端操作 */
public class ReturnOneElementInStream {
    static final List<String> LIST = Arrays.asList("A", "B", "C");

    public static void main(String[] args) {
        useFindAny();
        useFindFirst();
        searchEven();
    }

    /* ストリーム内の最初の要素を一つ戻す - findAny */
    private static void useFindAny() {
        Debug.log("useFindAny");
        Optional<String> str = LIST.parallelStream().findAny();
        str.ifPresent(System.out::println);  // A or B or C
    }

    /* ストリーム内の最初の要素を一つ戻す - findFirst */
    private static void useFindFirst() {
        Debug.log("useFindFirst");
        Optional<String> str = LIST.parallelStream().findFirst();
        str.ifPresent(System.out::println);  // A
    }

    /* 並列処理であっても、同じ要素を返却する - findFirst ※1 */
    private static void searchEven() {
        Debug.log("searchEven");
        // 偶数かどうかの判定式
        Predicate<Integer> ifEven = num -> {
            boolean result = num % 2 == 0;
            System.out.printf("%s : %s%n", num, result);
            return result;
        };
        // 最初に条件にマッチした値を出力
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.parallelStream().filter(ifEven)
                             .findFirst()
                             .ifPresent(System.out::println);  // 2
    }
}

/**
 * <pre>
 * findAny()
 *   - 基本的には、ストリーム内の最初の要素を持ったOptionalのインスタンスを返却
 *     - 並列時は、同じ要素を返却する保証はない
 *
 * findFirst()
 *   - 基本的には、ストリーム内の最初の要素を持ったOptionalのインスタンスを返却
 *     - 並列処理であっても、同じ要素を返却する
 * </pre>
 */