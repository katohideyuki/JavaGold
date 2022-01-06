package chapter_17;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 5つのメソッド定義<br>
 * - スレッドIDを取得するメソッドが3つ<br>
 * - ReentrantLockクラスのメソッドが2つ<br>
 * --- ロック、解除<br>
 */
public class Test {

  private final ReentrantLock lock = new ReentrantLock();

  // ロック
  public void lock() {
    this.lock.lock();
  }
  // 解除
  public void unlock() {
    this.lock.unlock();
  }

  public void first() {
    System.out.println(
        Thread.currentThread().getId()
        + ":1");
  }

  public void second() {
    System.out.println(
        Thread.currentThread().getId()
        + ":2");
  }

  public void third() {
    System.out.println(
        Thread.currentThread().getId()
        + ":3");
  }

}
