package chapter_12;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrierクラスの使用例<br>
 * - 同期化支援機能を提供するクラス<br>
 * - 複数のスレッドが待機ポイント（バリアー）まで到達するのを待機できるようにする<br>
 *
 */
public class SampleCyclicBarrier {
  public static void main(String[] a) {
    executeCyclic();
  }

  /**
   * 5つのスレッドが終了したら、処理（バリアーアクション）実行<br>
   */
  private static void executeCyclic() {
    ExecutorService exec = Executors.newFixedThreadPool(5);

    CyclicBarrier barrier = new CyclicBarrier(5, () -> {
      System.out.println("5つのスレッドがバリアーポイントに到達したため、バリアーアクションが実行されました");
    });

    // 5回Taskクラスのスレッドを実行
    for (int i = 0; i < 5; i++) {
      exec.submit(new Task(barrier));
    }

  }
}
