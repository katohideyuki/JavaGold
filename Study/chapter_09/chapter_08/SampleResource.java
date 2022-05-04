package chapter_08;

public class SampleResource implements AutoCloseable {
  @Override
  public void close() throws Exception {
    System.out.println("close");
  }
}
