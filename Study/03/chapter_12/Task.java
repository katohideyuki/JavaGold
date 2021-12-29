package chapter_12;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * スレッド定義クラス<br>
 * - スレッドIDを取得<br>
 * - 100 ~ 1000ミリ秒スリープ<br>
 * - スレッドを終了し、バリアーに通知<br>
 *
 */
public class Task implements Runnable {
  private CyclicBarrier barrier;

  // コンストラクタ
  public Task(CyclicBarrier barrier) {
    super();
    this.barrier = barrier;
  }

  // スレッドIDを取得
  @Override
  public void run() {
    long id = Thread.currentThread().getId();
    System.out.println("START: " + id);

    // ランダム秒スリープ
    int r = new Random().nextInt(10);
    try {
      Thread.sleep(r * 100);
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
    System.out.println("END: " + id);

    try {
      this.barrier.await(); // スレッド処理を中断（バリアーに通知）
    } catch (InterruptedException | BrokenBarrierException e) {
      throw new RuntimeException();
    }
  }

}
