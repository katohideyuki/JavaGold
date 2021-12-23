package chapter_06;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * scheduleWithFixedDelayメソッド<br>
 * - 処理と処理の間にほぼ一定のインターバルを挟む<br>
 * - 処理
 *
 */
public class SampleFixedDelay {
  public static void main(String[] args) throws InterruptedException {
    executeFixedDelay();
  }

  private static void executeFixedDelay() throws InterruptedException {
    ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
    exec.scheduleWithFixedDelay(() -> {
      // ▼ 処理
      int r = new Random().nextInt(3); // 乱数生成
      System.out.println(r + ":sleep");

      try {
        Thread.sleep(r * 1000);// 0〜3秒待機
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println("interrupt");
    }, 1, 1, TimeUnit.SECONDS);
    // ▲ 処理

    int count = 0;
    while (true) {
      Thread.sleep(100);
      System.out.print(">");
      count++;
      // 10秒たったらスレッドを閉じて、終了
      if (count == 100) {
        exec.shutdown();
        System.out.println("finish");
        break;
      }
    }

  }

}
