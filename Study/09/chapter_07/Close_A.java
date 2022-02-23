package chapter_07;

public class Close_A implements AutoCloseable {
  @Override
  public void close() throws Exception {
    System.out.println("A");
  }
}
