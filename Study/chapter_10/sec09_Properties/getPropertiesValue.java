package sec09_Properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import debug.Debug;

/** Properties の使用例 */
public class getPropertiesValue {
    public static void main(String[] args) {
        exe();
    }

    /* 既知のキーを指定して値を取得 */
    private static void exe() {
        Debug.log("exe");
        try {
            String key = "server_address";
            Properties prop = new Properties();
            prop.load(new FileReader("db_setting.properties"));
            System.out.printf("%s : %s %n",key, prop.getProperty(key));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * <pre>
 * Properties.getPropety("String 型")
 *   - 取り出したい値の key を渡して、value を取得する
 * </pre>
 */
