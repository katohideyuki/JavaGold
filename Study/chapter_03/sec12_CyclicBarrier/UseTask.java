package sec12_CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** CyclicBarrier クラスの使用例 */
public class UseTask {
    public static void main(String[] a) {
        useCyclicBarrier();
    }
    private static void useCyclicBarrier() {
        ExecutorService exec = Executors.newFixedThreadPool(5);

        // 5回通知が来たら、処理(バリアーアクション)を実行
        CyclicBarrier barrier = new CyclicBarrier(5, () -> {
            System.out.println("it's all done.");
            exec.shutdown();
        });

        // Taskクラスのスレッドを5回実行する
        for (int i = 0; i < 5; i++)
            exec.submit(new Task(barrier));
    }
}

/**
 * <pre>
 * CyclicBarrier(通知閾値, 実行処理)
 *   - 同期化支援機能を提供するクラス
 *     - 通知が通知閾値に達したら、処理を実行する
 * </pre>
 */
