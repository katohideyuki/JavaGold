package chapter_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executorクラスの使用例<br>
 * - 必要な数だけスレッド生成<br>
 *
 */
public class CachedThreadSample {
  public static void main(String[] args) throws InterruptedException {
    executeCachedThread();
  }

  /**
   * newCachedThreadPoolメソッド<br>
   * - タスクが実行されたとき、空のスレッドがなければ、新しくスレッドを生成<br>
   * - 空のスレッドがあれば、使い回す<br>
   * - タスクが終われば、空のスレッドとして60秒待機<br>
   * - 60秒間使用されなければ破棄され、60秒未満であれば再利用できる <br>
   *
   * @throws InterruptedException
   */
  private static void executeCachedThread() throws InterruptedException {
    ExecutorService exec = Executors.newCachedThreadPool(); // 必要に応じて、スレッドを自動生成
    // スレッドID取得をラムダ式で表現
    Runnable test = () -> {
      System.out.println(Thread.currentThread().getId());
    };

    for (int i = 0; i < 5; i++) {
      exec.submit(test); // 新しくスレッドが作られ、タスク実行
    }

    Thread.sleep(5000); // 5秒待機
    System.out.println("--- 5秒経過 ---");

    for (int i = 0; i < 5; i++) {
      exec.submit(test); // 過去のスレッドを使い回し、タスク実行
    }

    Thread.sleep(65000); // 65秒待機
    System.out.println("--- 65秒経過 ---");

    for (int i = 0; i < 5; i++) {
      exec.submit(test); // 過去のスレッドのキャッシュが切れているから、新しくスレッドが作られ、タスク実行
    }

  }

}
