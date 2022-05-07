package sec15_Atomic;

import java.util.concurrent.CyclicBarrier;

import threadRelated.BarrierAwait;

/** Atomic - Value インスタンスに100追加するタスクを定義 */
public class Task implements Runnable {
    private Value value;
    private CyclicBarrier barrier;

    /* コンストラクタ */
    public Task(Value value, CyclicBarrier barrier) {
        this.value   = value;
        this.barrier = barrier;
    }

    @Override /* タスク - add メソッドに100を渡す処理を50回繰り返す */
    public void run() {
        for (int i = 0; i < 50; i++)
            this.add(100);
        BarrierAwait.exe(barrier);
    }

    /* Value インスタンスに受け取った値を追加 */
    private void add(int num) {
        this.value.add(num);
    }
}
