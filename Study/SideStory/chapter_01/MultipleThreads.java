package chapter_01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 3つのThreadを定義<br>
 * - 各スレッド終了時は、戻り値として整数を返す<br>
 * - 各スレッドの戻り値の合計値を出力<br>
 *
 */
public class MultipleThreads {

  public static void executeThread() {
    ExecutorService thread = Executors.newFixedThreadPool(3);

    Future<Integer> xFuture = thread.submit(() -> {
      System.out.println("スレッドID : " + Thread.currentThread().getId());
    }, 30);

    Future<Integer> yFuture = thread.submit(() -> {
      System.out.println("スレッドID : " + Thread.currentThread().getId());
    }, 10);

    Future<Integer> zFuture = thread.submit(() -> {
      System.out.println("スレッドID : " + Thread.currentThread().getId());
    }, 20);

    try {
      int result = xFuture.get() + yFuture.get() + zFuture.get();
      System.out.println("合計 : " + result);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
