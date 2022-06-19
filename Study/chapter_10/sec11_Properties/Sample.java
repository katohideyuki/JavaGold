package sec11_Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Properties;

import debug.Debug;

/** Properties の使用例 - 文字コード */
public class Sample {
    static final Properties PROP  = new Properties();
    static final String FILE_NAME = "Japanese.properties";
    static final String UTF8      = "UTF-8";
    static final String READ_KEY  = "test";


    public static void main(String[] args) throws IOException {
        readUTF8UseFReader();
        readUTF8UseISReader();
    }

    /* UTF-8のプロパティファイルを Property オブジェクトで読み込む
         - FileReader を使用 */
    private static void readUTF8UseFReader() throws IOException {
        Debug.log("readUTF8UseFReader");
        PROP.load(new FileReader(FILE_NAME, Charset.forName(UTF8)));
        System.out.println(PROP.getProperty(READ_KEY));
    }

    /* UTF-8のプロパティファイルを Property オブジェクトで読み込む
         - InputStreamReader を使用 */
    private static void readUTF8UseISReader() throws UnsupportedEncodingException, FileNotFoundException, IOException {
        Debug.log("readUTF8UseISReader");
        PROP.load(new InputStreamReader(
                new FileInputStream(FILE_NAME), UTF8));
        System.out.println(PROP.getProperty(READ_KEY));
    }
}

/**
 * <pre>
 * Jaca SE 9から、ISO-8859-1のほかに、UTF-8で保存されたプロパティファイルも扱える
 * native2ascii コマンドで Unicode 形式に変換する必要がなくなった
 *
 * Charset.forName(文字コード)
 *   - 指定した文字コードでプロパティファイルが読み込まれる
 * </pre>
 */
