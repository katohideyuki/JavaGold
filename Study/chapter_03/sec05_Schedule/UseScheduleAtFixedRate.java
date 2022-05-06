package sec05_Schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import debug.Debug;
import threadRelated.Sleep;

/** scheduleAtFixedRate メソッドの使用例 */
public class UseScheduleAtFixedRate {
    public static void main(String[] args) throws InterruptedException {
        useScheduleAtFixedRate();
    }

    /* 1秒ごとにメッセージを出力し、100ミリ秒ごとにマーク「>」を出力 */
    private static void useScheduleAtFixedRate() {
        Debug.log("useScheduleAtFixedRate");

        // 1秒ごとにメッセージを出力するスレッド
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(() -> {
            System.out.println("interrupt");
        }, 1, 1, TimeUnit.SECONDS);

        // 100ミリ秒ごとにマーク「>」を出力 - 100回インクリメントしたらスレッドプールを終了し、ループを抜ける
        int count   = 0;
        String mark = ">";
        while (true) {
            Sleep.exe(100);
            System.out.print(mark);
            count++;
            if (count == 100) {
                exec.shutdown();
                System.out.println("finish");
                break;
            }
        }
    }
}

/**
 * <pre>
 * scheduleAtFixedRate( 処理内容, 初期遅延時間, インターバル時間, 時間の単位)
 *   - スレッドが終了するまで定期的に繰り返し実行する
 *   - 処理が
 *     - 処理ロジック
 *       1. 初期遅延 待機
 *       2. 処理実行 と インターバル時間のカウント開始
 *            - インターバル時間が経過していても、処理が終わっていなければ、次の処理は始まらない
 * </pre>
 */
