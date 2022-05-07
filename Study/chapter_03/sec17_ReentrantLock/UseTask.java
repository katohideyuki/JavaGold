package sec17_ReentrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import debug.Debug;
import threadRelated.Sleep;

/** ReentrantLock クラスの使用例 */
public class UseTask {
    private static final Test TEST = new Test();
    private static final ExecutorService EXEC = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        randomOrder();
        Sleep.exe(1000);
        useReenTrandLock();
        Sleep.exe(1000);
        EXEC.shutdown();
    }

    /* スレッドの実行順序が保証されていない時がある */
    private static void randomOrder() {
        Debug.log("randomOrder");
        EXEC.submit(new RandomOrderTask(TEST));
        EXEC.submit(new RandomOrderTask(TEST));
        EXEC.submit(new RandomOrderTask(TEST));
    }

    /* スレッドの実行順序が保証されている */
    private static void useReenTrandLock() {
        Debug.log("useReenTrandLock");
        EXEC.submit(new InOrderTask(TEST));
        EXEC.submit(new InOrderTask(TEST));
        EXEC.submit(new InOrderTask(TEST));
    }
}
