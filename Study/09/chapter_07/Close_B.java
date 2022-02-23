package chapter_07;

public class Close_B implements AutoCloseable {
  @Override
  public void close() throws Exception {
    System.out.println("B");
  }

}
