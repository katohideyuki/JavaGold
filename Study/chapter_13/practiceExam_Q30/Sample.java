package practiceExam_Q30;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import debug.Debug;

/** Files.deleteIfExists の使用例 */
public class Sample {
    public static void main(String[] args) {
        sample();
    }

    /* sample.txt が存在しな場合、deleteIfExists の結果は false を返却する */
    private static void sample() {
        Debug.log("sample");
        try {
            Path path = Paths.get("sample.txt");
            boolean result = Files.deleteIfExists(path);
            if (result) {
                System.out.println("A");
            } else {
                System.out.println("B");  // B
            }
        } catch (IOException e) {
            System.out.println("C");
        }
    }
}

/**
 * <pre>
 * Files.deleteIfExists()
 *   - パスで表現されるファイルやディレクトリが存在すれば削除する
 *     削除したかどうかを boolean 型の結果で返却する
 * </pre>
 */
