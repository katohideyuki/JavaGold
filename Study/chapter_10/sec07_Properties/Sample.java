package sec07_Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import debug.Debug;

/** Properties の使用例 */
public class Sample {
    static final Properties PORP = new Properties();
    public static void main(String[] args) {
        getProp();
        useForEach();
    }

    /* プロパティファイルの読み込み、value 値を出力 */
    private static void getProp() {
        Debug.log("getProp");
        try {
            PORP.load(new FileInputStream("db_setting.properties"));
            // キーを取得し、キーに紐づく value を出力
            Set<Object> keys = PORP.keySet();
            for (Object key : keys)
                System.out.println(PORP.get(key));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* プロパティファイルのすべての値を一覧表示 */
    private static void useForEach() {
        Debug.log("useForEach");
        try {
            PORP.load(new FileInputStream("db_setting.properties"));
            PORP.forEach((k, v) -> System.out.printf("%s=%s%n", k, v));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

/**
 * <pre>
 * プロパティファイルを読み込むには、次の手順で行う
 *   1. プロパティファイルを読み込む io.FileReader オブジェクトや
 *      io.FileInputStream オブジェクトを生成する
 *   2. Propaeries.load()の引数に、1で生成したインスタンスの参照を渡す
 *   3. Properties.get()や getProperty()にキーを渡して値を取得する
 *
 * Properties.get(Object 型)
 *   - Properties クラスのスーパークラスである util.Hashtable クラスから
 *     引き継いだメソッド
 *     - Hashtable がさまざまなオブジェクトの集合を扱うクラス
 *
 * Properties.getProperty(String 型)
 *   - Properties クラスに定義されたメソッド
 *     - 文字列のキーを指定して、文字列の値を返却する
 * </pre>
 */
