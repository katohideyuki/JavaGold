package sec10_Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import debug.Debug;
import threadRelated.FutureGet;
import threadRelated.Sleep;

/** Callable インターフェースの使用例 */
public class UseCallable {
    private static final ExecutorService EXEC = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        useCallNormal();
        Sleep.exe(2000);
        useCallLambda();
    }

    /* 乱数を生成し、それが偶数・奇数かの結果を返却するタスクを10回実行して、その結果を出力する */
    private static void useCallNormal() {
        Debug.log("useCallNormal");

        // タスクを定義
        Callable<Boolean> task = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return new Random().nextInt() % 2 == 0;
            }
        };

        // スレッドを10回実行し、実行結果をリストに追加
        List<Future<Boolean>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            futures.add(EXEC.submit(task));

        // 実行結果を出力
        addHelper(futures);
    }

    /* 乱数を生成し、それが偶数・奇数かの結果を返却するタスクを10回実行して、その結果を出力する - ラムダ式 */
    private static void useCallLambda() {
        Debug.log("useCallLambda");

        // タスクを定義して、そのままそのスレッドを10回実行し、実行結果をリストに追加
        List<Future<Boolean>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            futures.add(EXEC.submit(() -> {
                return new Random().nextInt() % 2 == 0;
            }));

        // 実行結果を出力
        addHelper(futures);
    }

    /* debug - リストの中身を出力し、偶数飲みをカウントする */
    private static void addHelper(List<Future<Boolean>> futures) {
        int countEven = 0;
        for (Future<Boolean> future : futures) {
            Boolean result = FutureGet.exe(future);
            System.out.println(result);
            if (result)
                countEven++;
        }
        System.out.printf("Count of even : %s", countEven);
    }
}

/**
 * <pre>
 * Callable インターフェース
 *   - 処理結果を戻したり、必要に応じて例外をスローしたりするマルチスレッドのタスクを定義できる
 *     - call メソッドが1つだけ定義されているため、ラムダ式で記述できる
 *     - 戻り値型は Callable インスタンスを取得する際に型パラメータで指定する
 * </pre>
 */