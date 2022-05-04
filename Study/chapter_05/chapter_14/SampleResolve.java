package chapter_14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 入出力<br>
 * createDirectories/resolveメソッド<br>
 *
 */
public class SampleResolve {
  public static void main(String[] a) {
    makeFile();
  }

  /**
   * ファイル生成<br>
   * - ディレクトリがなかったら、ディレクトリも生成する<br>
   */
  private static void makeFile() {
    var dir = Paths.get("dir", "subdir");
    var file = Paths.get("data.txt");
    if (Files.exists(dir) == false) {
      try {
        Files.createDirectories(dir);
        Files.createFile(dir.resolve(file));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
