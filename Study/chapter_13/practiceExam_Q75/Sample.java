package practiceExam_Q75;

import java.util.List;
import java.util.stream.IntStream;

import debug.Debug;

/** IntStream.range の使用例 */
public class Sample {
    public static void main(String[] args) {
        elementCombination();
    }

    /* 2つのリストを出力する */
    private static void elementCombination() {
        Debug.log("elementCombination");
        // 文字列を扱うリストを生成
        List<String> list  = List.of("A", "B", "C", "D");
        List<String> list2 = List.of("D", "E", "F", "G");

        // リスト内の index 0 ~ 3 の要素を出力する
        IntStream
            .range(0, Math.min(list.size(), list2.size()))
            .mapToObj(i -> list.get(i) + " " + list2.get(i))
            .forEach(System.out::println);    // AD BE CF DG
    }
}

/**
 * <pre>
 * IntStream.range(開始index, 数える上限index)
 *   - 第一引数に「どの値から開始するか」という初期値、第二引数に上限となる値を渡すと、
 *     上限の値を含まない範囲で、初期値から1つずつ増やした整数のストリームを構築する。
 * </pre>
 */
