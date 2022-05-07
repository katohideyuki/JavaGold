package sec14_Deadlock;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import threadRelated.BarrierAwait;

/** デッドロック - 発生しない */
public class NoDeadlock {
    public static void main(String[] args) {
        useBankAccount();
    }

    /* デッドロックが発生せず、正常に処理が終了する */
    private static void useBankAccount() {
        BankAccount a = new BankAccount(100);
        BankAccount b = new BankAccount(100);
        ExecutorService exec = Executors.newCachedThreadPool();

        // スレッドが完了したら、入金・出金後の預金残高を出力
        CyclicBarrier barrier = new CyclicBarrier(2, () -> {
            exec.shutdown();
            System.out.printf("a balance : %s%n", a);    // 110
            System.out.printf("b balance : %s%n", b);    // 90
        });

        // a => b の順でロックを取得し、口座を操作する ※1
        exec.submit(() -> {
            synchronized (a) {
                a.withdrawals(20);                       // a アカウントをロックし、-20の出金を行う
                synchronized (b) { b.deposit(20); }      // b アカウントをロックし、+20の入金を行う
            }
            BarrierAwait.exe(barrier);
        });

        // a => b の順でロックを取得し、口座を操作する ※1
        exec.submit(() -> {
            synchronized (a) {
                a.deposit(30);                           // a アカウントをロックし、+30の入金を行う
                synchronized (b) { b.withdrawals(30); }  // b アカウントをロックし、-30の出金を行う
            }
            BarrierAwait.exe(barrier);
        });
    }
}

/**
 * <pre>
 * ※1
 * デッドロックを防ぐため、ロックする順番をスレッド間で揃える
 * </pre>
 */
