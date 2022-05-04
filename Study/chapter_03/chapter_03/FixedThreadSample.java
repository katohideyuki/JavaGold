package chapter_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executorクラスの使用例<br>
 * - 3つのスレッドを使い回し、5回タスクを実行<br>
 * --- 3つのスレッドIDが表示<br>
 *
 */
public class FixedThreadSample {
  public static void main(String[] args) {
    executeFixeThread();
  }

  /**
   * newFixedThreadPoolメソッド<br>
   * - タスクを待つ新しいスレッドを引数の数だけ作成<br>
   */
  private static void executeFixeThread() {
    ExecutorService exec = Executors.newFixedThreadPool(3); // Executorを3つ作成

    for (int i = 0; i < 5; i++) {
      exec.submit(() -> {
        System.out.println(Thread.currentThread().getId()); // スレッドIDを取得
      });
    }
  }

}
