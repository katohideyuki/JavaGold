package chapter_04;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorServiceインターフェースの使用例
 * - 処理を1回だけ遅らせて実行<br>
 *
 */
public class SampleSchedule {
  public static void main(String[] args) throws InterruptedException {
    executeSchedule();
  }

  /**
   * ScheduledExecutorServiceインターフェース<br>
   * - scheduleメソッド<br>
   * --- 遅延実行<br>
   * ----- 処理内容, 遅延時間, 時間の単位<br>
   * <br>
   * @throws InterruptedException<br>
   */
  private static void executeSchedule() throws InterruptedException {
    ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor(); // スレッド1つ作成

    // submitメソッドで処理を渡されてから1秒遅れて実行
    exec.schedule(() -> {
      System.out.println("finish");
      exec.shutdown();  // スレッドプールを閉じる
    }, 1, TimeUnit.SECONDS);

    int count = 0;
    while (true) {
      Thread.sleep(100);
      // スレッドが閉じていたら終了
      if (exec.isShutdown()) {
        break;
      }
      System.out.println((++count) * 100 + "ms");
    }
  }

}
