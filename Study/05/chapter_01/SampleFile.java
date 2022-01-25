package chapter_01;

import java.io.File;
import java.io.IOException;

/**
 * 入出力<br>
 * - exists/createNewFile/mkdir/getAbsolutePathメソッド<br>
 *
 */
public class SampleFile {
  public static void main(String[] a) {
    executeFile();
  }

  /**
   * Fileクラス<br>
   */
  private static void executeFile() {
    File file = new File("data.txt");
    File dir = new File("Data");
    // 存在チェック
    if (dir.exists() == false) {
      dir.mkdir();  // ディレクトリ生成
      if (file.exists() == false) {
        try {
          file.createNewFile(); // ファイル生成
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      System.out.println(file.getAbsolutePath()); // パス取得
    }
  }
}
