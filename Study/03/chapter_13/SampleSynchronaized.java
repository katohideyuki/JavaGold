package chapter_13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * スレッド競合した場合<br>
 * - 300を出力されるが、何回かに一回スレッド競合が発生し、200が表示される<br>
 *
 */
public class SampleSynchronaized implements Runnable {
  private int num = 100;

  public static void main(String[] a) {
    SampleSynchronaized sample = new SampleSynchronaized();
    ExecutorService exec = Executors.newFixedThreadPool(10);

    exec.submit(sample);
    exec.submit(sample);

    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println(sample.num);
    exec.shutdown();// スレッド終了
  }

  // 引数をnumフィールドに加算
  public void add(int amount) {
    this.num += amount;
  }

  // スレッド処理
  @Override
  public void run() {
    add(100);
  }
}
