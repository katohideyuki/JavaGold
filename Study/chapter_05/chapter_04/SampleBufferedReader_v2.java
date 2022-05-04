package chapter_04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

/**
 * 入出力<br>
 * - BufferReaderクラス/readLine/linesメソッド<br>
 * -
 */
public class SampleBufferedReader_v2 {
  public static void main(String[] a) {
    readFile(makeFile("a.txt"));
    readFile(makeFile("b.txt"));
  }

  /**
   * Optionalを使ってみた<br>
   * - ファイル名を引数にBufferedReaderインスタンスを持ったOptionalインスタンスを返す<br>
   * - ファイルが見つからなかったとき、空のOptionalインスタンスを返す<br>
   * @param name
   * @return Optionalインスタンス
   */
  private static Optional<BufferedReader> makeFile(String name) {
    System.out.println("▼ ファイル名「" + name + "」を出力します。");

    BufferedReader buffer = null; // 初期化
    try {
      FileReader file = new FileReader(name);
      buffer = new BufferedReader(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return Optional.ofNullable(buffer);
  }

  /**
   * optionalインスタンスを受け取り、値あり/なしに応じて処理を変える<br>
   * @param reader
   */
  private static void readFile(Optional<BufferedReader> opReader) {
    opReader.ifPresentOrElse(reader -> {
      try (reader){
        reader.lines().forEach(x -> System.out.println(x));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }, () -> System.out.println("ファイルが見つかりませんでした"));
  }
}
