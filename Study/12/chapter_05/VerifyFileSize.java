package chapter_05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * セキュアコーディング<br>
 * Dos攻撃<br>
 */
public class VerifyFileSize {
  static final int FILE_SIZE_LIMIT = 100;
  static String FILE_NAME = "GoodSample.txt";

  public static void main(String[] a) {
    exe(FILE_NAME);
  }

  /**
   * DoS攻撃対策<br>
   * 例：ファイルを読み込む前にファイルサイズの制限をする<br>
   *
   * @param ファイル名
   */
  private static void exe(String fileName) {
    try {
      long fileSize = Files.size(Paths.get(fileName));
      if (fileSize > FILE_SIZE_LIMIT) {
        throw new IOException(String.format("File too large : %d", fileSize));
      } else if (fileSize == 0L) {
        throw new IOException(String.format("File size cannot be determined", fileSize));
      }
      System.out.println("File size OK");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
