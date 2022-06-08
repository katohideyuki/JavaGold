package sec05_Closeable;

import java.io.Closeable;
import java.io.IOException;

/** try-with-resources の使用例
      - Closeable を実装したクラス */
public class SampleCloseable implements Closeable {
    @Override
    public void close() throws IOException {
        System.out.println("close");
    }
}
