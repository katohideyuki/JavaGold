package sec03_Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import debug.Debug;
import threadRelated.Sleep;

/** Executors クラスの使用例 */
public class UseExecutors {

    /* 各スレッドに渡すタスク内容 - スレッドID を取得 */
    private static final Runnable RUN = () ->
        System.out.printf("Thread id : %s%n", Thread.currentThread().getId());

    public static void main(String[] args) {
        useSingleThread();
        Sleep.exe(2000);
        useFixedThread();
        sleep(2000);
        useCachedThread();
    }

    /* 1つのスレッドで5回タスクを実行 - newSingleThreadExecutor */
    private static void useSingleThread() {
        Debug.log("useSingleThread");
        ExecutorService exec = Executors.newSingleThreadExecutor(); // 空スレッドを作成
        for (int i = 0; i < 5; i++)
            exec.submit(RUN);
    }

    /* 3つのスレッドで5回タスクを実行 - newFixedThreadPool */
    private static void useFixedThread() {
        Debug.log("useFixedThread");
        ExecutorService exec = Executors.newFixedThreadPool(3); // 空のスレッドを3つ作る
        for (int i = 0; i < 5; i++)
            exec.submit(RUN);
    }

    /* 必要に応じたスレッドで5回タスクを実行 - newCachedThreadPool */
    private static void useCachedThread() {
        Debug.log("useCachedThread");
        ExecutorService exec = Executors.newCachedThreadPool(); // 必要に応じて空のスレッドが自動で作られる
        for (int i = 0; i < 5; i++)
            exec.submit(RUN);   // 新しくスレッドが作られ、タスク実行

        sleep(10_000);
        System.out.println("------ 10秒後 ------");

        for (int i = 0; i < 5; i++)
            exec.submit(RUN);   // 過去のスレッドを使い回し、タスク実行

        sleep(70_000);
        System.out.println("------ 70秒後 ------");

        for (int i = 0; i < 5; i++)
            exec.submit(RUN);   // 過去のスレッドのキャッシュが切れているため、新しくスレッドが作られ、タスク実行
    }
}

/**
 * <pre>
 * ExecutorSerive.submit
 *   - ExecutorService のスレッドにタスクを与えて実行する
 *
 * Executors.newSingleThreadExecutor
 *   - 新しいスレッドを1つだけ作ってプールしている、ExecutorService を作る
 *
 * Executors.newFixedThreadPool
 *   - 生成したいスレッド数を引数に受け取り、生成した分だけのタスク待ちスレッドを保持するスレッドプールを作る
 *
 * Executors.newCachedThreadPool
 *   - 必要に応じてスレッドを自動で増減させるスレッドプールを作る
 *     - タスクが実行されたとき、空のスレッドがなければ新しくスレッドを生成
 *     - 1度生成されたスレッドは、60秒未満であれば再利用され、60秒以上使用されなければ破棄される
 *
 * </pre>
 */
