package chapter_15;

/**
 * Taskクラスで処理されるクラス
 *
 */
public class Value {
  private int num = 0;

  public void add(int num) {
    this.num += num;
  }

  public int get() {
    return num;
  }

}
