package sec09_FutureReturnVal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import threadRelated.FutureGet;
import threadRelated.Sleep;

/** Future インターフェースの使用例 - 戻り値あり */
public class UseFuture {
    public static void main(String[] args) {
        futureReturnVal();
    }

    /* Future.get() でnull以外の戻り値を取得する */
    private static void futureReturnVal() {
        ExecutorService exec = Executors.newSingleThreadExecutor();

        // スレッドが終了したら、文字列"finish"を返却する
        Future<String> future = exec.submit(() -> {
           System.out.println("Task start");
           Sleep.exe(2000);
           System.out.println("Task end");
        }, "finish");

        // スレッドの戻り値を取得
        String result = FutureGet.exe(future);
        System.out.println(result);
    }
}

/**
 * <pre>
 * Runnable型のタスクを実行して、null以外の値を返却したい場合
 * オーバーロードされた submit メソッドの第2引数に戻り値を指定する
 *   - 戻り値の型は Future の型パラメータで指定する
 *   - Runnable型のタスクで返却する値は、固定値のみ
 * </pre>
 */
