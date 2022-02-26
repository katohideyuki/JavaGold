package chapter_07;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * ローカライズ<br>
 * Propertiesクラス/get/getPropertiesメソッド<br>
 */
public class PropertiesFileUsage {
  public static void main(String[] a) {
    exe();
  }

  /**
   * Properties.getメソッド<br>
   * - 引数がObject型<br>
   *
   * Properties.getPropertyメソッド<br>
   * - 引数がString型<br>
   */
  private static void exe() {
    try {
      // Propertiesインスタンス生成し、プロパティファイルを読み込む
      var prop = new Properties();
      prop.load(new FileReader("db_setting.properties"));

      // キーの一覧を取り出し、キーに一致する値を表示
      Set keys = prop.keySet(); // Setのジェネリックを指定していないので、暗黙的にObject型となる
      for (Object key : keys) {
        System.out.printf("プロパティファイル「db_setting.properties」 : %s %n", prop.get(key));
      }

      // BiConsumer型のラムダで記述
      prop.forEach((key, val) -> System.out.printf("(key = value) %s = %s %n", key, val));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
