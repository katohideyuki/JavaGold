package sec06_Schedule;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import ch02_commonUtil.Sleep;

/* scheduleWithFixedDelay メソッドの使用例
     - 各スレッドが実行する処理時間がランダムに変わる */
public class FixedAtRate {

    /* scheduleAtFixedRate - インターバル時間が不定 */
    public  static void exe() {
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();

        // 100 ~ 1秒ごとにメッセージを出力するスレッド
        exec.scheduleAtFixedRate(() -> {
            int sleepTime = new Random().nextInt(10) * 100; // ([0~10] * 100)ミリ秒スリープする時間
            System.out.printf(" %s time sleep. ", sleepTime);
            Sleep.exe(sleepTime);
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
 * 連続して処理が繰り返されるが、処理と処理の間のインターバルが一定じゃない
 * </pre>
 */
