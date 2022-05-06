package sec10_Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callableインターフェースの使用例<br>
 * - callメソッドを一つだけ持つ<br>
 *
 */
public class SampleCallable{
  public static void main(String[] a) throws InterruptedException, ExecutionException {
    executeCallable();
  }

  /**
   * Callableのインスタンスを生成<br>
   * - 偶数判定ができるよう、callメソッドをオーバーライド<br>
   * - スレッドの戻り値（結果）をlistに追加<br>
   * - 偶数のみカウント<br>
   * @throws ExecutionException
   * @throws InterruptedException
   *
   */
  private static void executeCallable() throws InterruptedException, ExecutionException {
    ExecutorService exec = Executors.newSingleThreadExecutor();

    // 偶数判定
    Callable<Boolean> task = new Callable<Boolean>() {
      @Override
      public Boolean call() {
        return new Random().nextInt() % 2 == 0;
      }
    };

    List<Future<Boolean>> futures = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      futures.add(exec.submit(task));
    }

    int total = 0;
    for (Future<Boolean> future : futures) {
      Boolean result = future.get();
      System.out.println(result);

      if (result) {
        total++;
      }
    }
    System.out.println(total);
  }

}
