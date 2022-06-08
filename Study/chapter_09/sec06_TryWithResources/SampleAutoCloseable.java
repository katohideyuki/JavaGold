package sec06_TryWithResources;

/** try-with-resources の使用例
      - AutoCloseable を実装したクラス  */
public class SampleAutoCloseable implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("close");
    }
}
