package sec10_Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import threadRelated.FutureGet;

/** Callable インターフェースの使用例 */
public class UseCallable {
    public static void main(String[] args) {
        useCallNormal();
    }

    private static void useCallNormal() {
        ExecutorService exec = Executors.newSingleThreadExecutor();

        // 乱数を生成し、偶数であれば true、 奇数であれば false を返却するタスク
        Callable<Boolean> task = new Callable<Boolean>() {
            @Override /* 乱数の値が偶数であれば true */
            public Boolean call() throws Exception {
                return new Random().nextInt() % 2 == 0;
            }
        };
        // スレッドを10回実行し、実行結果をリストに追加
        List<Future<Boolean>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            futures.add(exec.submit(task));

        // スレッドの結果を取得し、偶数のみカウントする
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