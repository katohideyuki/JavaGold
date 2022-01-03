package chapter_16;

import java.util.List;

/**
 * リストの要素に書き込むスレッドを持ったクラス<br>
 * - リストに10~19を追加<br>
 *
 */
public class WriteTask implements Runnable {
  private List<Integer> list;

  // コンストラクタ
  public WriteTask(List<Integer> list) {
    this.list = list;
  }

  @Override
  public void run() {
    for (int i = 10; i < 20; i++) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      list.add(i);
    }
  }

}
