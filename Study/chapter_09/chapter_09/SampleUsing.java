package chapter_09;

import java.util.stream.Stream;

/**
 * 例外とアサーション<br>
 * 抑制された例外<br>
 */
public class SampleUsing {
  public static void main(String[] args) {
    exe();
  }

  /**
   * 抑制された例外を取り出す<br>
   * - e.getSuppressed()は、抑制されて例外への参照をThrowable配列型で戻す<br>
   * - close内で発生した例外は、tryブロック内で発生した例外の内部に隠されるため<br>
   */
  private static void exe() {

    try (var su = new SampleResource()) {
      throw new Exception(); // 例外発生
    } catch (Exception e) {
      System.out.println("catch");
      Stream.of(e.getSuppressed()).forEach(x -> System.out.println(x));
    } finally {
      System.out.println("finally");
    }
  }
}
