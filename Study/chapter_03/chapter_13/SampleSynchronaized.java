package chapter_13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A)スレッド競合した場合<br>
 * - 300を出力されるが、何回かに一回スレッド競合が発生し、200が表示される<br>
 * B)排他制御をかけた場合<br>
 * - addメソッド宣言時にsynchronized修飾子を宣言し、排他制御をかける<br>
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
//  public void add(int amount) { // A
//    this.num += amount;
//  }

  //
  public synchronized void add(int amount) { // B
    this.num += amount;
  }

  // スレッド処理
  @Override
  public void run() {
    add(100);
  }
}
