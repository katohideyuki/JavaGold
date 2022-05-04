package chapter_06;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

/**
 * 入出力<br>
 * BufferedWriterクラス/newLine/flushメソッド<br>
 *
 */
public class SampleBufferedWriter {
  public static void main(String[] args) {
    makeFile("BufferedWriteSample.txt", true);
  }

  /**
   * BufferedWriterインスタンス生成メソッド<br>
   *
   * @param name      ファイル名
   * @param writeMode 上書き/追記
   */
  private static void makeFile(String name, Boolean writeMode) {
    BufferedWriter bw = null;
    try {
      bw = new BufferedWriter(new FileWriter(name, writeMode));
    } catch (IOException e) {
      e.printStackTrace();
    }
    outPut(Optional.ofNullable(bw));
  }

  /**
   * ファイル生成メソッド<br>
   * - まれに1,2で差異があるらしいので、flushメソッド (同期)を実行<br>
   * --- 1) BufferedWriter.writeメソッドによりバッファに書き込まれたデータ<br>
   * --- 2) 実際に生成された「***.txt」ファイル<br>
   * ----- 1を元に2へ同期（バッファのファイルが優先）<br>
   *
   * @param bw Optionalインスタンス
   */
  private static void outPut(Optional<BufferedWriter> bw) {
    bw.ifPresentOrElse(value -> {
      try (value) {
        value.newLine(); // 改行
        value.write("writeメソッドから書き込まれました。");
        value.newLine();
        value.write("writeメソッドから書き込まれました。");
        value.flush(); // 同期
      } catch (IOException e) {
        e.printStackTrace();
      }
    }, () -> System.out.println("ファイルが見つかりませんでした。"));
  }
}
