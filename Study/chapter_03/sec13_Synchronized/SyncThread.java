package sec13_Synchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import threadRelated.Sleep;

/** 排他制御 - 競合しないプログラム */
public class SyncThread implements Runnable {
    private int num;

    /* 100回スレッドを実行し、num フィールドの値が10,000になる */
    public static void exe() {
        SyncThread st = new SyncThread();
        ExecutorService exec = Executors.newCachedThreadPool();

        // 100回スレッド実行
        for (int i = 0; i < 100; i++)
            exec.submit(st);

        // 結果を出力し、スレッドプールを閉じる
        Sleep.exe(200);
        System.out.println(st.num);
        exec.shutdown();
    }

    /* num フィールドに引数をプラス - 排他制御 */
    public synchronized void add(int amount) { num = num + amount; }

    @Override /* num フィールドに+100 */
    public void run() { add(100); }
}

/**
 * <pre>
 * synchronized 修飾子
 *   - まず、synchronizedを使うことの無いよう、設計すること
 *   - この修飾子が付与されたクラス、またはメソッドが処理している間は、
 *     別のスレッドがその処理を実行できないよう待機させる
 * </pre>
 */