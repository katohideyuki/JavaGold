package chapter_14;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * デッドロックを発生させるクラス<br>
 *
 */
public class Bank {
  public static void main(String[] a) {
    executeThread();
  }

  /**
   * スレッド1にて、bankAインスタンスをロック<br>
   * スレッド2にて、bankBインスタンスをロック<br>
   * - デッドロック発生<br>
   */
  public static void executeThread() {
    BankAccount bankA = new BankAccount(100);
    BankAccount bankB = new BankAccount(100);
    ExecutorService exec = Executors.newFixedThreadPool(2);

    // デッドロックにより、バリアーアクションは実行されない
    CyclicBarrier barrier = new CyclicBarrier(2, () -> {
      System.out.println(bankA.getBalance());
      System.out.println(bankB.getBalance());
    });

    // スレッド1
    exec.submit(() -> {
      synchronized (bankA) {
        bankA.withdrawals(20); // bankA -20
        synchronized (bankB) {
          bankB.deposit(20); // bankB +20
        }
      }
      try {
        barrier.await(); // バリアー通知
      } catch (InterruptedException | BrokenBarrierException e) {
        e.printStackTrace();
      }
    });

    // スレッド2
    exec.submit(() -> {
      synchronized (bankB) {
        bankB.withdrawals(30); // bankB -30
        synchronized (bankA) {
          bankA.deposit(30); // bankA +30
        }
      }
      try {
        barrier.await(); // バリアー通知
      } catch (InterruptedException | BrokenBarrierException e) {
        e.printStackTrace();
      }
    });
  }
}
