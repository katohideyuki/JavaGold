package practiceExam_Q78;

import java.util.List;
import java.util.function.Consumer;

import debug.Debug;

/** Consumer.andThen */
public class Sample {
    public static void main(String[] args) {
        synthesis();
    }

    /* 変換前と小文字変換後の文字列を出力 */
    private static void synthesis() {
        Debug.log("synthesis");

        List<String> list = List.of("A", "B", "C");
        Consumer<String> a = System.out::print;
        Consumer<String> b = a.andThen(str -> System.out.printf(":%s%n", str.toLowerCase()));
        list.forEach(b);    // A:a B:b C:c
    }
}

/**
 * <pre>
 * Consumer.andThen()
 *   - Consumer オブジェクトを合成し、連続した処理を行う。
 *   - andThen で繋がっている左辺から順に実行されていく。
 * </pre>
 */
