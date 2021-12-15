package chapter_01;

public class Sample {
  public static void main(String[] args) {
    excuteThread();
  }

  /**
   * SampleThreadクラスのstartメソッドを実行<br>
   * - 並行処理として、「main」と表示させる<br>
   */
  private static void excuteThread() {
    Thread t = new SampleThread(); // 新しいスレッドクラスのインスタンスを生成
    t.start(); // runメソッド実行

    System.out.println("main");
  }
}
