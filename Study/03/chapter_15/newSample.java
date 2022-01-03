package chapter_15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * スレッド実行クラス<br>
 * - 同一のインスタンスに対して、二つのスレッドが実行される<br>
 * - Atomicクラスを使用することで、競合を回避している<br>
 *
 */
public class newSample {
  public static void main(String[] a) {
    executeAtomic();
  }

  private static void executeAtomic() {
    Value val = new AtomicValue();

    ExecutorService exec = Executors.newFixedThreadPool(2);

    exec.submit(new Task(val)); // 競合しない
    exec.submit(new Task(val)); // 競合しない

    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(val.get());
    exec.shutdown(); // スレッド終了
  }

}
