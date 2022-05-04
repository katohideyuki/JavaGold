package chapter_15;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicIntegerクラスの使用例<br>
 * - Valueクラスを継承し、排他制御をする<br>
 *
 */
public class AtomicValue extends Value{
  private AtomicInteger num = new AtomicInteger();

  public void add(int num) {
    this.num.addAndGet(num);
  }

  public int get() {
    return this.num.intValue();
  }


}
