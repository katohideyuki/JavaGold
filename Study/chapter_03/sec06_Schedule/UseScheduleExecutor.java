package sec06_Schedule;

import ch03_commonUtil.Sleep;
import debug.Debug;

/* scheduleWithFixedDelay メソッドの使用例
     - 各スレッドが実行する処理時間がランダムに変わる */
public class UseScheduleExecutor {
    public static void main(String[] args) {
        useFixedRate();
        Sleep.exe(5000);  // FixedRate と FixedDelay メソッドが並列にならないようスリープ
        useFixedDelay();
    }

    /* scheduleAtFixedRate */
    private static void useFixedRate() {
        Debug.log("useFixedRate");
        FixedAtRate.exe();
    }

    /* scheduleWithFexedDelay */
    private static void useFixedDelay() {
        Debug.log("useFixedDelay");
        FixedDelay.exe();
    }
}
