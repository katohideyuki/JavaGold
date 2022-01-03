package chapter_15;

/**
 * Valueクラスを受け取って処理するクラス<br>
 * - スレッド実行でValueインスタンスに100追加<br>
 *
 */
public class Task implements Runnable {
  private Value val;

  // コンストラクタ
  public Task(Value val) {
    this.val = val;
  }

  @Override
  public void run() {
    this.add(100);
  }

  private void add(int num) {
    this.val.add(num);
  }


}
