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
 * - ラムダver<br>
 *
 */
public class SampleCallableLambda {
  public static void main(String[] a) throws InterruptedException, ExecutionException {
    executeCallable();
  }

  /**
   * Callableのインスタンスを生成<br>
   * - ラムダで表現した場合、どのインターフェースを使っているのかを以下で判断する<br>
   * --- 戻り値があれば、Runnableインターフェース<br>
   * --- 戻り値がなければ、Callableインターフェース<br>
   *
   * @throws ExecutionException<br>
   * @throws InterruptedException<br>
   */
  private static void executeCallable() throws InterruptedException, ExecutionException {
    ExecutorService exec = Executors.newSingleThreadExecutor();

    // callメソッドのオーバーライドをラムダで表現（戻り値があるからCallableインターフェース)
    List<Future<Boolean>> futures = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      futures.add(exec.submit(() -> {
        return new Random().nextInt() % 2 == 0; // 戻り値
      }));
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
