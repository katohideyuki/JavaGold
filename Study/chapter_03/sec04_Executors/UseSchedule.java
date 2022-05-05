package sec04_Executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import debug.Debug;

/** ScheduleExecutorService インターフェースの使用例 */
public class UseSchedule {
    public static void main(String[] args) throws InterruptedException {
        useSchedule();
    }

    /* スレッドを1秒遅延実行し、スレッドを終了する */
    private static void useSchedule() {
        Debug.log("useSchedule");

        // 新しいスレッドを作り1秒後に処理が実行され、スレッドプールを閉じる
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.schedule(() -> {
            System.out.println("finish");
            exec.shutdown();
        }, 1, TimeUnit.SECONDS);

        // 計測するため、100ミリ秒ごとに出力
        int count = 0;
        while (true) {
            slepp(100);
            if (exec.isShutdown()) // スレッドが終了していれば終了
                break;
            System.out.printf("%s ms %n", ++count * 100);
        }
    }

    /* debug - 例外処理を記述すると冗長になるため Thread.sleep を切り離す */
    private static void slepp(long time) throws RuntimeException {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * <pre>
 * ScheduleExecutorService( 処理内容, 遅延時間, 時間の単位 )
 *   - メソッドを遅延実行する
 *
 * ExecutorService.shutdown()
 *   - 実行後、新規タスクは受け付けない
 *   - 実行中のタスクは継続される
 *
 * ExecutorService.isShutdown()
 *   - スレッドが終了していれば true
 * </pre>
 */
