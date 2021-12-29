package chapter_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 別スレッドで発生した例外を受け取り、例外処理する<br>
 *
 */
public class SampleExecution {
  public static void main(String[] a) throws InterruptedException {
    executeExecution();
  }

  /**
   * ExecutionoException<br>
   * - スレッドで発生した例外は、呼び出し元にスローされない<br>
   * --- Futureがいったん受け取る<br>
   * --- getメソッド呼び出し時に例外処理をする必要がある<br>
   */
  private static void executeExecution() throws InterruptedException {
    ExecutorService exec = Executors.newSingleThreadExecutor();
    List<Future<Boolean>> futures = new ArrayList<>();

    // 奇数であればtrueを返し, 偶数であれば例外をスロー
    for (int i = 0; i < 10; i++) {
      futures.add(exec.submit(() -> {
        if (new Random().nextInt() % 2 == 0) {
          throw new Exception("Odd Number");
        }
        return true;
      }));
    }

    // 奇数をカウントし、偶数（例外）は例外処理
    int total = 0;
    for (Future<Boolean> future : futures) {
      Boolean result = false;
      try {
        result = future.get(); // スレッドで例外発生した場合、getメソッドはExecutionExceptionをスローする
        System.out.println(result);
      } catch (ExecutionException e) {
        System.out.println(e.getMessage());
      }
      if (result) {
        total++;
      }
    }
    System.out.println(total);
  }

}
