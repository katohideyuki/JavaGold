package chapter_08;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * ローカライズ<br>
 * Properties.listメソッド<br>
 */
public class PropertiesList {
  public static void main(String[] a) {
    exe();
  }

  /**
   * Properties.listメソッド<br>
   * - 引数にPrintStream型、PrintWriter型を受け取り、プロパティファイルの中身を一覧表示<br>
   * - デバッグ時とかに使える<br>
   */
  private static void exe() {
    var prop = new Properties();
    try {
      prop.load(new FileReader("db_setting.properties"));
      prop.list(System.out); // PrintStreamクラスのoutフィールドの参照を渡す
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
