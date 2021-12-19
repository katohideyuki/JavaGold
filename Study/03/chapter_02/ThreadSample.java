package chapter_02;

/**
 * Runnableを実現し、Threadのコンストラクタに渡してスレッドを作る<br>
 *
 */
public class ThreadSample {
  public static void main(String[] args) {
    excuteThread();
    excuteThreadLambda();
  }

  /**
   * 匿名クラス<br>
   * - runメソッドをオーバーライドし、スレッドをスタート<br>
   */
  private static void excuteThread() {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Threadのコンストラクタの引数を匿名クラスで表現");
      }
    });
    thread.start();
  }

  /**
   * ラムダ<br>
   * - runメソッドをオーバーライドし、スレッドをスタート<br>
   */
  private static void excuteThreadLambda() {
    Thread thread = new Thread(() -> {
      System.out.println("Threadのコンストラクタの引数をラムダ式で表現");
    });
    thread.start();
  }
}
