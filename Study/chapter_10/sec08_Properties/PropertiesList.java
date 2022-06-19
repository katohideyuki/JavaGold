package sec08_Properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import debug.Debug;

/** Properties の使用例 */
public class PropertiesList {
    public static void main(String[] a) {
        exe();
    }

    /* プロパティファイルの値を一覧表示 */
    private static void exe() {
        Debug.log("exe");
        Properties prop = new Properties();
        try {
            prop.load(new FileReader("db_setting.properties"));
            prop.list(System.out); // PrintStreamクラスのoutフィールドの参照を渡す
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * <pre>
 * Properties.list(PrintStream 型 または printWriter 型)
 *   - プロパティファイルの中身を一覧表示する
 *   - デバッグ時などで使用
 * </pre>
 */
