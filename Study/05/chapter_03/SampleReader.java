package chapter_03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 入出力<br>
 * FileReaderクラス/read/closeメソッド<br>
 * (後日いろいろ試してみる)<br>
 *
 */
public class SampleReader {
  public static void main(String[] args) {
    executeBadReader();
    try {
      executeGoodReader(); // 結局こっちでキャッチすることに...見づらい
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * テキストファイルを読み込みコンソールに出力<br>
   * FileReaderクラスのメソッドにて、例外のケアが必要<br>
   * - read / closeメソッド <br>
   * ダメな例<br>
   * - 例外処理が冗長になり分かりづらい<br>
   */
  private static void executeBadReader() {
    System.out.println("▼ readメソッド");
    FileReader reader = null; // finallyブロックからアクセスするため

    try {
      reader = new FileReader("BadSample.txt");
      int number = 0; // 文字ごとに振られた番号

      // ファイル読み込み
      while ((number = reader.read()) != -1) {
        char c = (char) number; // 番号 -> 文字（1文字）
        System.out.print(c);
      }
      System.out.println("");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close(); // closeメソッドで例外が発生する可能性あり
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * テキストファイルを読み込みコンソールに出力<br>
   * FileReaderクラスのメソッドにて、例外のケアが必要<br>
   * 微妙な例<br>
   * - try with resourceを使って、closeメソッドのtry分は簡略化<br>
   * - ただし、FileNotFoundExceptionをスローすることになってしまった<br>
   * - キャッチしたいけど、そのためにtry文を書いたら本末転倒<br>
   */
  private static void executeGoodReader() throws FileNotFoundException {
    System.out.println("▼ try with resourceで例外ケア");
    FileReader reader = new FileReader("GoodSample.txt"); // FileNotFoundExceptionの可能性
    try (reader) {
      int number;
      while ((number = reader.read()) != -1) {
        char c = (char) number;
        System.out.print(c);
      }
      System.out.println("");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
