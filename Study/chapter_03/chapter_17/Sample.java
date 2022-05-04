package chapter_17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Taskスレッド実行<br>
 * - スレッドの実行順序が保証されていないexecuteNoInOrderメソッド<br>
 * - スレッドの実行順序が保証されているexecuteInOrderメソッド<br>
 *
 */
public class Sample {
  public static void main(String[] a) {
//    executeNoInOrder(); // 順不同
    executeInOrder(); // 順番通り
  }

  /**
   * - Taskスレッドを3回実行<br>
   * - スレッド実行の順番が保証されていない<br>
   * - バラバラにスレッドが実行される<br>
   */
  private static void executeNoInOrder() {
    Test test = new Test();
    ExecutorService exec = Executors.newFixedThreadPool(3);

    // Taskスレッドを3回実行
    System.out.println("▼ 順番通りではない");
    exec.submit(new Task(test));
    exec.submit(new Task(test));
    exec.submit(new Task(test));
  }

  /**
   * - Taskスレッドを3回実行<br>
   * - スレッド実行の順番が保証されている<br>
   * - 順番通りスレッドが実行される<br>
   */
  private static void executeInOrder() {
    Test test = new Test();
    ExecutorService exec = Executors.newFixedThreadPool(3);

    // finallyブロックでunlockを呼ぶことで、スレッド中に例外発生しても、解除される ※catchは一旦スルー
    try {
      System.out.println("▼ 順番通り");
      test.lock();
      exec.submit(new Task(test));
      exec.submit(new Task(test));
      exec.submit(new Task(test));
    } finally {
      test.unlock();
    }

  }

}
