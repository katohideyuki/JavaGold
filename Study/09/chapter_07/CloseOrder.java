package chapter_07;

/**
 * 例外とアサーション<br>
 * try-with-resourceの閉じる順番<br>
 */
public class CloseOrder {
  public static void main(String[] args) throws Exception {
    exe();
  }

  /**
   * どの順番でリソースがクローズされていくのかを確認<br>
   * - try()内に記述した順で閉じていく<br>
   * --- インスタンス生成した順番ではない<br>
   *
   * @throws Exception
   */
  private static void exe() throws Exception {
    Close_A a = new Close_A();
    try (a; Close_B b = new Close_B(); Close_C c = new Close_C()) {
    }
  }
}
