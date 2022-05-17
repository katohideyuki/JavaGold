package sec22_StreamCollector;

import java.util.Arrays;
import java.util.List;

import debug.Debug;

/** Collector インターフェースの使用例 */
public class UseCollector {
    static final List<String> LIST = Arrays.asList("A", "B", "C", "D", "E");

    public static void main(String[] args) {
        useCollect();
        useCollectParallel();
    }

    /* ストリームの文字列を連結する繰り返し処理 - collect ※1 */
    private static void useCollect() {
        Debug.log("useCollect");
        String result = LIST.stream().collect(new CollectorRealization());
        System.out.println(result);
    }

    /* ストリームの文字列を連結する繰り返し処理 - 並列処理 */
    private static void useCollectParallel() {
        Debug.log("useCollectParallel");
        String result = LIST.parallelStream().collect(new CollectorRealization());
        System.out.println(result);
    }
}

/**
 * <pre>
 * ※1
 * sec21_StreamLambda パッケージで説明した、懸念点が解消されている
 *   - ラムダ式で行っていた処理をCollectorRealization クラスに移動したため、再利用できる
 *   - 副作用がない
 * </pre>
 */