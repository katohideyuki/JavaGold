package chapter_08;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SampleFutureGet {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    executeFutureGet();
  }

  /**
   * スレッドを1つ生成<br>
   * タスクが終了したら、future.getメソッド実行<br>
   * - スレッドの処理完了するまで、future.getメソッドは処理が走らない<br>
   * @throws InterruptedException
   * @throws ExecutionException
   */
  private static void executeFutureGet() throws InterruptedException, ExecutionException {
    ExecutorService exec = Executors.newSingleThreadExecutor();
    Future future = exec.submit(() -> {

      try {
        System.out.println("Thread start");
        Thread.sleep(2000);
        System.out.println("Thread end");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
    // execスレッドが終了していたら、実行
    if(future.get() == null) {
      System.out.println("Thread finish");
    }
  }

}
