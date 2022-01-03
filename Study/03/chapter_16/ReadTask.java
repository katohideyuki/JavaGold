package chapter_16;

import java.util.List;

/**
 * リストの要素を読み出すスレッドを持ったクラス
 *
 */
public class ReadTask implements Runnable {
  private List<Integer> list;

  // コンストラクタ
  public ReadTask(List<Integer> list) {
    this.list = list;
  }

  @Override
  public void run() {
    for (Integer integer : list) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println(integer);
    }
  }

}
