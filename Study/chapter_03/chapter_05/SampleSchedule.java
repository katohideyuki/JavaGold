package chapter_05;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SampleSchedule {
  public static void main(String[] args) throws InterruptedException {
    executeSchedule();
  }

  /**
   * scheduleAtFixedRateメソッド<br>
   * - 連続して繰り返す処理<br>
   * - 初期遅延が終わり次第インターバル開始<br>
   * - 処理が終わってからインターバルが開始されるのではない<br>
   * @throws InterruptedException
   */
  private static void executeSchedule() throws InterruptedException {
    ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor(); // スレッドを1つ作成

    // 処理が渡されてから1秒遅れて実行
    exec.scheduleAtFixedRate(() -> {
      System.out.println("interrupt");  // 処理内容
    }, 1, 1, TimeUnit.SECONDS); // 初期遅延、インターバル時間、時間の単位

    int count = 0;
    while(true) {
      Thread.sleep(100);
      System.out.print(">");
      count++;
      // 10秒たったらスレッドを閉じて、終了
      if(count == 100) {
        exec.shutdown();
        System.out.println("finish");
        break;
      }
    }

  }

}
