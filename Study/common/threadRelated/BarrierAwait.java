package threadRelated;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/** 例外処理を記述すると冗長になるため CyclicBarrier.await を切り離す */
public class BarrierAwait {
    public static void exe(CyclicBarrier barrier) {
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

}
