package chapter_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executorクラスの使用例<br>
 * - 新しいスレッドを1つ作成し、プールしておく<br>
 * - submitを呼び出し、タスクを与えて実行<br>
 * --- 1つのスレッドを使い回し、5回タスクを実行<br>
 * ------ 同一のスレッドIDが5回表示される<br>
 *
 */
public class SingleThreadSample {
  public static void main(String[] args) {
    excuteSingleThread();
  }

  /**
   * newSingleThreadExcutorメソッド<br>
   * - タスクを待つ新しいスレッドを１つだけ作成<br>
   * <br>
   * submitメソッド<br>
   * - タスクを与えて実行<br>
   */
  private static void excuteSingleThread() {
    ExecutorService exec = Executors.newSingleThreadExecutor(); // 1つのExecutorを作成

    for (int i = 0; i < 5; i++) {
      // Executorにタスクを与えて実行
      exec.submit(() -> {
        System.out.println(Thread.currentThread().getId()); // スレッドIDを取得
      });
    }

  }
}
