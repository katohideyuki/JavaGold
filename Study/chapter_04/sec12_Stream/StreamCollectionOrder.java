package sec12_Stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import debug.Debug;

/** Stream.forEach の使用例 - コレクションが保持している順に処理 */
public class StreamCollectionOrder {
    private static final List<String> LIST = Arrays.asList("E", "D", "C", "B", "A");
    public static void main(String[] args) {
        outOrderAddtion();
        outOrderHash();
    }

    /* List の中身を順に出力 - 追加した順*/
    private static void outOrderAddtion() {
        Debug.log("outOrderAddtion");
        LIST.stream().forEach(System.out::println);
    }

    /* SET の中身を順に出力 - ハッシュコード順 */
    private static void outOrderHash() {
        Debug.log("outOrderHash");
        Set<String> set = new HashSet<String>(LIST);
        set.stream().forEach(System.out::println);
    }
}

/**
 * <pre>
 * Stream.forEach
 *   - ストリーム内の要素をコレクションが保持している順に処理する
 *     - ArraysList は、要素を追加した順
 *     - HashSet は、ハッシュコード順
 * </pre>
 */