package chapter_17;

/**
 * スレッドの処理内容を定義<br>
 *
 */
public class Task implements Runnable{
  private Test test;

  // コンストラクタ
  public Task(Test test) {
    super();
    this.test = test;
  }

  @Override
  public void run() {
    test.first();
    test.second();
    test.third();
  }
}
