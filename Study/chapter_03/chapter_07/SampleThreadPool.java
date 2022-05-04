package chapter_07;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * newScheduledThreadPoolメソッドの使用例<br>
 *
 */
public class SampleThreadPool {
  public static void main(String[] args) throws InterruptedException {
    executeThreadPool();
  }

  /**
   * 2つのスレッドを生成して、2タスクを実行<br>
   * 10秒後にスレッド終了<br>
   * @throws InterruptedException
   *
   */
  private static void executeThreadPool() throws InterruptedException {
    ScheduledExecutorService exec = Executors.newScheduledThreadPool(2);
    // スレッド1
    exec.scheduleWithFixedDelay(() -> {
      System.out.println("A");
    }, 1, 1, TimeUnit.SECONDS);
    // スレッド2
    exec.scheduleWithFixedDelay(() -> {
      System.out.println("B");
    }, 1, 1, TimeUnit.SECONDS);

    // メインの処理を10間秒スリープして、2つのスレッドを閉じる
    Thread.sleep(10000);
    exec.shutdown();
    System.out.println("End");

  }

}
