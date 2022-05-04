package chapter_04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 入出力<br>
 * - BufferReaderクラス/readLine/linesメソッド<br>
 */
public class SampleBufferedReader {
  public static void main(String[] a) {
    outPut_v1(readFile("b.txt"));
    outPut_v2(readFile("a.txt"));
  }

  /**
   * BufferReaderインスタンス生成メソッド<br>
   * - close, readLineメソッドなどの例外処理と重なると見づらいから、切り離した<br>
   * - ラムダで対応しようと思ったが、引き数3つ以上のFunction型がデフォルトでないから諦めた<br>
   *
   * @param name
   * @return
   */
  private static BufferedReader readFile(String name) {
    try {
      FileReader fileReader = new FileReader(name);
      BufferedReader reader = new BufferedReader(fileReader);
      return reader;
    } catch (FileNotFoundException e) {
      System.out.println("ファイルが見つかりません。");
      e.printStackTrace(); // FileReader
    }
    return null;
  }

  /**
   * BufferedReaderインスタンスを引数に、ファイルの中身を出力<br>
   * - nullチェックが見づらい<br>
   *
   * @param reader
   */
  private static void outPut_v1(BufferedReader reader) {
    System.out.println("▼ outPut_v1メソッド");
    String oneLine = null;

    try (reader) {
      if (reader != null) {
        while ((oneLine = reader.readLine()) != null) {
          System.out.println(oneLine);
        }
      } else {
        System.out.println("BufferedReaderのインスタンス生成できませんでした。");
      }
    } catch (IOException e) {
      e.printStackTrace(); // close, readeLine
    }
  }

  /**
   * ストリームAPIを使ったversion<br>
   * - BufferedReader.lines()<br>
   * --- BufferedReaderで記述されたテキスト行を提供するStreamを戻す<String>
   *
   * @param reader
   */
  private static void outPut_v2(BufferedReader reader) {
    System.out.println("▼ outPut_v2メソッド");
    try (reader) {
      if (reader != null) {
        reader.lines().forEach(x -> System.out.println(x));
      } else {
        System.out.println("BufferedReaderのインスタンス生成できませんでした。");
      }
    } catch (IOException e) {
      e.printStackTrace(); // close, readLine
    }
  }
}
