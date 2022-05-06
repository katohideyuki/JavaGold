package sec11_ExceptionInThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/** 別スレッドで発生した例外を受け取り、例外処理する */
public class ExceptionHandlingThread {
    public static void main(String[] a) {
        exe();
    }

    private static void exe() {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<Boolean>> futures = new ArrayList<>();

        // 乱数を生成し、偶数であれば true、奇数であれば例外をスローするタスクを10回実行する
        for (int i = 0; i < 10; i++) {
            futures.add(exec.submit(() -> {
                if (new Random().nextInt() % 2 != 0)
                    throw new RuntimeException("Odd Number!"); // 原因となる例外をスロー
                return true;
            }));
        }

        // 実行結果を出力
        int countEven = 0;
        for (Future<Boolean> future : futures) {
            Boolean result = false;
            try {
                // 例外が発生していれば、catch で定義した例外で　原因となる例外をラップしてスローする
                result = future.get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getCause());              // 原因となった例外を取り出す
            }
            if (result)
                countEven++;
        }
        System.out.printf("Count of even : %s", countEven);
    }
}

/**
 * <pre>
 * スレッド実行中に発生した例外は、そのまま呼び出し元にはスローされない
 *   - スローされた例外はFutureがいったん受け取り、
 *     InterruptedException または ExecutionException　に置き換えて、
 *     呼び出し元にスローされる
 *     - つまり、本来の例外内容を知りたければ、Future.get メソッド実行時に
 *       本来の例外を取得する処理をする必要がある
 * </pre>
 */
