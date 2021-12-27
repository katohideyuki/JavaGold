package chapter_09;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Futureインターフェースの使用例
 *
 */
public class SampleFuture {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    executeFuture();
  }

  /**
   * Future.getメソッドでnull以外の値を戻すとき<br>
   * - オーバーロードされたsubmitメソッドの第二引数に戻り値を指定<br>
   */
  private static void executeFuture() throws InterruptedException, ExecutionException {
    ExecutorService exec = Executors.newSingleThreadExecutor();
    Future<String> future = exec.submit(() -> {
      try {
        System.out.println("start");
        Thread.sleep(2000);
        System.out.println("end");
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }, /* Future.get()の戻り値 */ "finish");

    String result = future.get();
    System.out.println(result);

  }

}
