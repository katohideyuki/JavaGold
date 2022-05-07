package sec13_Synchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import threadRelated.Sleep;

/** 排他制御 - 競合するプログラム */
public class ConflictThread implements Runnable {
    private int num;

    /* 100回スレッドを実行し、num フィールドの値が10,000になる想定
         - 競合が発生し、10,000にならない時がある */
    public static void exe() {
        ConflictThread ct = new ConflictThread();
        ExecutorService exec = Executors.newCachedThreadPool();

        // 100回スレッド実行
        for (int i = 0; i < 100; i++)
            exec.submit(ct);

        // 結果を出力し、スレッドプールを閉じる
        Sleep.exe(200);
        System.out.println(ct.num);
        exec.shutdown();
    }

    /* num フィールドに引数をプラス */
    public void add(int amount) { num = num + amount; }

    @Override /* num フィールドに+100 */
    public void run() { add(100); }
}
