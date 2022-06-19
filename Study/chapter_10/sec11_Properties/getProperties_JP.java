package sec11_Properties;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * ローカライズ<br>
 * Charsetクラス/forNameメソッド<br>
 */
public class getProperties_JP {
  private static final Properties PROP = new Properties();
  private static final String FILE_NAME = "Japanese.properties";

  public static void main(String[] args) {
    exe();
    exe2();
  }

  /**
   *　FileReaderクラスのコンストラクタの第二引数で文字コードを指定する場合<br>
   * - CharsetクラスのforNameメソッドを使用して、文字コードを指定<br>
   */
  private static void exe() {
    try {
      PROP.load(new FileReader(FILE_NAME, /* 第二引数 */Charset.forName("UTF-8")));
      System.out.println(PROP.getProperty("test"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * InputStreamReaderクラスのコンストラクタの第二引数で文字コードを指定する場合<br>
   * - そのまま文字コードを指定するだけ<br>
   */
  private static void exe2() {
    try {
      PROP.load(new InputStreamReader(new FileInputStream(FILE_NAME), /* 第二引数 */"utf-8"));
      PROP.list(System.out);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
