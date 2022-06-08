package sec05_Closeable;


import java.io.IOException;

import debug.Debug;

/** try-with-resources の使用例 */
public class UseCloseable {

    public static void main(String[] args) {
        useSampleAutoCloseable();
        useSampleCloseable();
    }

    /* AutoCloseable を使用 */
    private static void useSampleAutoCloseable() {
        Debug.log("useSampleAutoCloseable");
        try (var sample = new SampleAutoCloseable()) {
            throw new Exception();
        } catch (Exception e) {
            System.out.printf("useSampleAutoCloseable is failue : %s%n", e);
        }
    }

    /* Closeable を使用 */
    private static void useSampleCloseable() {
        Debug.log("useSampleCloseable");
        try (var sample = new SampleCloseable()) {
            throw new IOException();
        } catch (IOException e) {
            System.out.printf("useSampleCloseable is failue : %s%n", e);
        }
    }
}

/**
 * <pre>
 * try-with-resources
 *   - 「()」で扱えるのは、以下インタフェースを実装したクラスのみ
 *     - lang.AutoCloseable インタフェース : Exception をスローする
 *     - io.Closeable インタフェース       : IOException をスローする
 * </pre>
 */
