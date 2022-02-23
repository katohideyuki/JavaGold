package chapter_09;

public class SampleResource implements AutoCloseable {
  /**
   * close内で例外発生<br>
   */
  @Override
  public void close() throws Exception {
    System.out.println("close");
    throw new RuntimeException("抑制された例外");
  }
}
