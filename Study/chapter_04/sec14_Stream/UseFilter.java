package sec14_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import debug.Debug;

/** Stream.filter の使用例 */
public class UseFilter {
    static final List<Integer> LIST = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) {
        useMethodChain();
        notUseMethodChain();
        filterTwice();
    }

    /* 偶数のみ出力 - メソッドチェイン */
    private static void useMethodChain() {
        Debug.log("outOnlyEven");
        LIST.stream()
            .filter(num -> num % 2 == 0)
            .forEach(System.out::println);
    }

    /* 偶数のみ出力 - メソッドチェインを使わない */
    private static void notUseMethodChain() {
        Debug.log("notUseMethodChain");
        Stream<Integer> list = LIST.stream();
        Stream<Integer> evenList = list.filter(num -> num % 2 == 0);
        evenList.forEach(System.out::println);
    }

    /* 5以上の数字かつ偶数のみ出力 - filter を2回実行する */
    private static void filterTwice() {
        Debug.log("filterTwice");
        LIST.stream()
            .filter(num -> num >= 5)
            .filter(num -> num % 2 == 0)
            .forEach(System.out::println);
    }
}

/**
 * <pre>
 * Stream.filter(Predicate 型ラムダ)
 *   - ラムダ式で指定された条件に一致するかどうかでストリーム内の要素を絞り込む
 *   - 絞り込み処理は、複数回行うことができる
 * </pre>
 */
