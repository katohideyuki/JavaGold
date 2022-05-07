package sec14_Deadlock;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import threadRelated.BarrierAwait;

/** デッドロック - 発生 */
public class DeadlockOccurred {
    public static void main(String[] args) {
        useBankAccount();
    }

    /* デッドロックが発生し、処理が止まる */
    private static void useBankAccount() {
        BankAccount a = new BankAccount(100);
        BankAccount b = new BankAccount(100);
        ExecutorService exec = Executors.newCachedThreadPool();

        // スレッドが完了したら、入金・出金後の預金残高を出力
        CyclicBarrier barrier = new CyclicBarrier(2, () -> {
            exec.shutdown();
            System.out.println(a);
            System.out.println(b);
        });

        // a => b の順でロックを取得し、口座を操作する ※1
        exec.submit(() -> {
            synchronized (a) {
                a.withdrawals(20);                   // a アカウントをロックし、-20の出金を行う
                synchronized (b) { b.deposit(20); }  // b アカウントをロックし、+20の入金を行う
            }
            BarrierAwait.exe(barrier);
        });

        // b => a の順でロックを取得し、口座を操作する ※1
        exec.submit(() -> {
            synchronized (b) {
                b.withdrawals(30);                   // b アカウントをロックし、-30の出金を行う
                synchronized (a) { a.deposit(30); }  // a アカウントをロックし、+30の入金を行う
            }
            BarrierAwait.exe(barrier);
        });
    }
}

/**
 * <pre>
 * ※1
 * 2つのスレッドでロックする順番が異なっている
 *   - 1つ目のタスクで変数 a をロックした状態で、b にアクセスしようとしている
 *   - 2つ目のタスクで変数 b をロックした状態で、a にアクセスしようとしている
 *     - 結果、どちらのスレッドも処理を進めることができない
 * </pre>
 */
