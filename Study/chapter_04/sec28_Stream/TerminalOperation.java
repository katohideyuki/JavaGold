package sec28_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import debug.Debug;

/** 終端操作は、1回しか呼び出せない */
public class TerminalOperation {
    public static void main(String[] args) {
        callOnlyOnce();
    }

    /* 終端操作は、1回しか呼び出せません - 設問25 */
    private static void callOnlyOnce() {
        Debug.log("callOnlyOnce");
        List<Integer> list = Arrays.asList(1, 2, 3);
        Stream<Integer> stream = list.stream();
        System.out.println(stream.count());   // 終端操作1回目の呼び出し
        stream.forEach(System.out::println);  // 終端操作2回目の呼び出し => 例外発生
    }
}

/**
 * <pre>
 * 終端操作は、1回しか呼び出せません
 *   - 一度、終端操作を実行すると、そのストリーム・パイプラインは終了する
 *     - 2回目の呼び出し時に、異常な状態を表す IllegalStateExecption が発生する
 * </pre>
 */