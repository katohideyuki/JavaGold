package sec15_Stream;

import java.util.Arrays;
import java.util.List;

import debug.Debug;

/** ストリーム内の要素を、さまざまな方法で絞り込む */
public class VariousStreamFilter {
    public static void main(String[] args) {
        delDuplicate();
        norrowDownNum();
        otherThanNorrowDownNum();
        useValue();
    }

    /* 重複を取り除いた要素を出力 - distinct */
    private static void delDuplicate() {
        Debug.log("delDuplicate");
        List<String> list = Arrays.asList("A", "B", "C", "D", "A");
        list.stream()
            .distinct()
            .forEach(System.out::println);
   }

    /* 数で絞り込んだ要素を出力 - limit */
    private static void norrowDownNum() {
       Debug.log("norrowDownNum");
       List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
       list.stream()
           .limit(5)
           .forEach(System.out::println);
    }

    /* 数で絞り込んだ以外 - skip */
    private static void otherThanNorrowDownNum() {
        Debug.log("otherThanNorrowDownNum");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream()
            .skip(5)
            .forEach(System.out::println);
    }

    /* 設問15 - distinct を実行すると、リストの中身は常に「同値である」と見なされ、要素が1つになる */
    private static void useValue() {
        Debug.log("useValue");
        // Value インスタンスを扱うリスト
        List<Value> list = Arrays.asList(
                new Value("A"),
                new Value("B"),
                new Value("C"),
                new Value("A"));

        // リスト内の重複を削除し、要素を数える　- デバッグとして重複削除後のリストを出力
        long size = list.stream()
                        .distinct()
                        .peek(x -> System.out.printf("Duplicate deleted list : %s%n", x))
                        .count();
        System.out.printf("  => count : %s%n",  size);
    }
}

/**
 * <pre>
 * Stream.distinct()
 *   - ストリーム内の要素の重複を取り除く
 *     - 重複しているかどうかは、equals メソッドの結果が true になるかどうかで判定
 *
 * Stream.limit(絞り込む数)
 *   - ストリーム内の要素を、先頭から数えて、指定した数の要素に絞り込む
 *
 * Stream.skip(絞り込む数)
 *   - ストリーム内の要素を、先頭から数えて、指定した数以外の要素に絞り込む
 * </pre>
 */