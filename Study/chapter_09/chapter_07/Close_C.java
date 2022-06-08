package chapter_07;

/** try-with-resources の使用例
      - AutoCloseable を実装したクラス */
public class Close_C implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("C");
    }
}
