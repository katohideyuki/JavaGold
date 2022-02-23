package chapter_08;

/**
 * 例外とアサーション<br>
 * try-with-resource内で例外発生した場合の処理順<br>
 */
public class SampleUsing {
  public static void main(String[] args) {
    exe();
  }

  /**
   * try-with-resource内で例外発生<br>
   * close, catch , finallyの順番で処理されている事を確認<br>
   * - tryブロックを抜けるタイミングで、close処理される<br>
   */
  private static void exe() {

    try (var su = new SampleResource()) {
      throw new Exception(); // 例外発生
    } catch (Exception e) {
      System.out.println("catch");
    } finally {
      System.out.println("finally");
    }
  }
}
