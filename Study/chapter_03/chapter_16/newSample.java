package chapter_16;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 二つのタスクを実行するクラス<br>
 * - CopyOnWriteArrayListクラスを使用することで競合を回避<br>
 * - 初期値として、1~3がリストに追加されている<br>
 *
 */
public class newSample {
  public static void main(String[] a) {
    executeCollection();
  }

  private static void executeCollection() {
    List<Integer> list = new CopyOnWriteArrayList<Integer>();

    for (int i = 1; i < 4; i++) {
      list.add(i);
    }
    ExecutorService exec = Executors.newFixedThreadPool(2);
    exec.submit(new WriteTask(list)); // 書き込みスレッド
    exec.submit(new ReadTask(list)); // 読み出しスレッド

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    exec.shutdown();

    // WriteTask実行後の要素を確認
    System.out.println("---");
    list.forEach(System.out::println);
  }
}
