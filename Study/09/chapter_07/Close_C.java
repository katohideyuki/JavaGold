package chapter_07;

public class Close_C implements AutoCloseable {
  @Override
  public void close() throws Exception {
    System.out.println("C");
  }

}
