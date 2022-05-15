package sec13_ParallelStream;

import java.util.ArrayList;
import java.util.List;

import debug.Debug;
import threadRelated.Sleep;

/** parallelStream の使用例 */
public class UseParallelStream {

    public static void main(String[] args) {
        outParallel();
        Sleep.exe(100);
        outParallelControl();
        Sleep.exe(100);
        outStream();
    }

    /* List の中身を並列に出力 - 処理順は毎回バラバラ*/
    private static void outParallel() {
        Debug.log("outParallel");
        List<Integer> list = add100Num();  // 1~10,000の数字が入ったリスト ※1
        var startTime = System.currentTimeMillis();

        list.parallelStream().forEach(System.out::print);

        var endTime = System.currentTimeMillis();
        System.out.printf("%n 処理樹間 : %sミリ秒 %n", endTime - startTime);
    }

    /* List の中身を並列に出力 - 並列だけど、処理順を制御 */
    private static void outParallelControl() {
        Debug.log("outParallelControl");
        List<Integer> list = add100Num();  // 1~10,000の数字が入ったリスト ※1
        var startTime = System.currentTimeMillis();

        list.parallelStream().forEachOrdered(System.out::print);

        var endTime = System.currentTimeMillis();
        System.out.printf("%n 処理樹間 : %sミリ秒 %n", endTime - startTime);
    }

    /* List の中身を逐次処理で出力 */
    private static void outStream() {
        Debug.log("outStream");
        List<Integer> list = add100Num();  // 1~10,000の数字が入ったリスト ※1
        var startTime = System.currentTimeMillis();

        list.stream().forEach(System.out::print);

        var endTime = System.currentTimeMillis();
        System.out.printf("%n 処理樹間 : %sミリ秒 %n", endTime - startTime);
    }

    /* debug - 1 ~ 10,000の数字を順番にリストに追加 */
    private static List<Integer> add100Num() {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 10_000; i++)
            list.add(i);
        return list;
    }
}

/**
 * <pre>
 * Stream.parallelStream()
 *   - 並列処理
 *
 * Stream.forEachOrdered(Consumer ラムダ式)
 *   - 処理する順番をコレクションが保持している順に処理
 *
 * ※1
 * 使用するリストは、同じ条件にするため、各メソッド内で用意する
 *   - 正しく計測できていない気がする
 * </pre>
 */