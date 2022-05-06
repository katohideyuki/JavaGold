package sec08_Future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import threadRelated.Sleep;

/** Future インターフェースの使用例 */
public class UseFuture {
    public static void main(String[] args) {
        useFutureGet();
    }

    /* タスクを実行し、完了していれば完了メッセージを出力 */
    private static void useFutureGet() {
        ExecutorService exec = Executors.newSingleThreadExecutor();

        // タスク実行
        Future<?> future = exec.submit(() -> {
            System.out.println("Process start");
            Sleep.exe(2000);
            System.out.println("Process end");
        });

        // タスクが完了していれば、メッセージ出力
        try {
            if (future.get() == null)
                System.out.println("Task completed");
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * <pre>
 * Future インターフェース
 *   - スレッドを生成したメソッドが、新しく作ったスレッドの結果を知ることができる
 *
 * Future.get()
 *   - スレッドが終了していれば、get メソッドが実行され、処理結果を取得する
 *     - 処理が終了するまで、get メソッドは実行されない
 *   - 処理結果を返却しないスレッドの場合、null を取得する
 * </pre>
 */
