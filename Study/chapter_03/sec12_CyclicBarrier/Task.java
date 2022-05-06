package sec12_CyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import threadRelated.Sleep;

/** CyclicBarrier クラスの使用例
      - CyclicBarrier インスタンスを受け取り、タスクを実行後、バリアーに通知 */
public class Task implements Runnable {
    private CyclicBarrier barrier;

    // コンストラクタ
    public Task(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override /* タスク - 0 ~ 1秒スリープしたあと、スレッドを終了し、バリアーに通知 */
    public void run() {
        long id = Thread.currentThread().getId(); // スレッドID 取得
        System.out.printf("START : %s%n", id);

        // [0-10] * 100秒スリープ
        int randomNum = new Random().nextInt(10) * 100;
        Sleep.exe(randomNum);

        System.out.printf("END : %s%n", id);

        // スレッドを終了し、バリアーに通知
        try {
            this.barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * <pre>
 * CyclicBarrier.await
 *   - 処理を中断し、バリアーに通知
 * </pre>
 */
