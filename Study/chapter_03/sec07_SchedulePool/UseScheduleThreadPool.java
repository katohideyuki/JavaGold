package sec07_SchedulePool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import threadRelated.Sleep;

/** Executors.newScheduleThreadPool メソッドの使用例 */
public class UseScheduleThreadPool {
    public static void main(String[] args) {
        performTwoTasks();
    }

    /* 2つのスレッドを生成して、2つのタスクを実行 */
    private static void performTwoTasks() {
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(2);

        // 1つ目のタスク
        exec.scheduleWithFixedDelay(() -> {
            System.out.println("First task  : A");
        }, 1, 1, TimeUnit.SECONDS);

        // 2つ目のタスク
        exec.scheduleWithFixedDelay(() -> {
            System.out.println("second task : B");
        }, 1, 1, TimeUnit.SECONDS);

        // 10秒後にスレッドプールを閉じる
        Sleep.exe(10000);
        exec.shutdown();
        if (exec.isShutdown())
            System.out.println("finish.");
    }
}
