package chapter_15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * スレッド実行クラス<br>
 * - 同一のインスタンスに対して、二つのスレッドが実行される<br>
 * - 競合が発生し、100が返ってくる時がある<br>
 *
 */
public class Sample {
  public static void main(String[] a) {
    executeAtomic();
  }

  private static void executeAtomic() {
    Value val = new Value();

    ExecutorService exec = Executors.newFixedThreadPool(2);

    exec.submit(new Task(val)); // 競合
    exec.submit(new Task(val)); // 競合

    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(val.get());
    exec.shutdown(); // スレッド終了
  }

}
