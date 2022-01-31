package chapter_09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

/**
 * 入出力<br>
 * Scannerクラス/hasNext/nextメソッド<br>
 *
 */
public class SampleScanner {
  public static void main(String[] a) {
    textLoad("a.txt");
    textLoad("NotFound.txt");
  }

  /**
   * ファイル名を受け取り、そのファイルを読み込む<br>
   * @param name
   */
  private static void textLoad(String name) {
    Scanner scanner = null;
    try {
      scanner = new Scanner(new FileInputStream(name));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    execute(Optional.ofNullable(scanner));
  }

  /**
   * ファイル読み込み処理<br>
   * @param scannerOp
   */
  private static void execute(Optional<Scanner> scannerOp) {
    scannerOp.ifPresentOrElse(scanner -> {
      try(scanner) {
        while (scanner.hasNext()) { // 次に読み込む行があればtrue
          System.out.println(scanner.next()); // 一行読み込む
        }
      } catch (Exception e) {
        e.printStackTrace();  //hasNext, next, close
      }
    }, () -> System.out.println("ファイルが見つかりませんでした"));
  }

}
