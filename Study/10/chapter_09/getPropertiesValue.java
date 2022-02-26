package chapter_09;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * ローカライズ<br>
 * Properties.getPropertiesメソッド<br>
 */
public class getPropertiesValue {
  public static void main(String[] args) {
    exe();
  }

  /**
   * getPropertiesメソッド<br>
   * - 任意のKeyに紐づくvalueのみ取得<br>
   * - Stringを返す<br>
   */
  private static void exe() {
    try {
      var serverAddress = "server_address";
      Properties prop = new Properties();
      prop.load(new FileReader("db_setting.properties"));
      System.out.printf("任意の値のみ表示 : %s %n", prop.getProperty(serverAddress));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
