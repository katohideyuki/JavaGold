package chapter_05;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

/**
 * 入出力<br>
 * - FileWriterクラス/writeメソッド<br>
 *
 */
public class SampleWriter {
  public static void main(String[] a) {
    makeWriter("writeSample.txt");  // writeSample.txt生成
    makeWriter("src"); // FileNotFoundException発生（srcという名前のフォルダが既にあるため）
    makeWriter_v2("writeSample.txt", true); // trueで追記
  }

  /**
   * FileWriterインスタンス生成メソッド<br>
   * - 第二引数を指定していないため、同名のファイルがあった場合は上書きされる<br>
   * @param name
   */
  private static void makeWriter(String name) {
    FileWriter fw = null;
    try {
      fw = new FileWriter(name);
    } catch (IOException e) {
      e.printStackTrace(); // 指定した名前と同じディレクトリがあった時など
    }
    outPut(Optional.ofNullable(fw));
  }

  /**
   * FileWriterインスタンス生成メソッド<br>
   * - 第二引数によって、上書き/追記モードを判定<br>
   * @param name
   * @param writeMode
   */
  private static void makeWriter_v2(String name, Boolean writeMode) {
    FileWriter fw = null;
    try {
      fw = new FileWriter(name, writeMode);
    } catch (IOException e) {
      e.printStackTrace(); // 指定した名前と同じディレクトリがあった時など
    }
    outPut(Optional.ofNullable(fw));
  }

  /**
   * ファイル生成メソッド<br>
   * makeWriterメソッドから呼ばれる<br>
   * Optionalインスタンスを受け取り、値あり/なしに応じて処理する<br>
   *
   * @param fwOptional
   */
  private static void outPut(Optional<FileWriter> fwOptional) {
    fwOptional.ifPresentOrElse(fw -> {
      try (fw) {
        fw.write("writeメソッドから書き込んでいます。");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }, () -> System.out.println("ファイルが見つかりませんでした。"));
  }
}
