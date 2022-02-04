package chapter_13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * 入出力<br>
 * nio.file.Filesクラス<br>
 *
 */
public class SampleNio {
  public static void main(String[] args) {
    nioRelated();
  }

  /**
   * コンソールから入力を受付、ファイルが無ければ生成<br>
   * nio.file.Filesクラスの使用例<br>
   *
   */
  private static void nioRelated() {
    System.out.println(">");
    var scan = new Scanner(System.in); // コンソール入力からファイル名を受け取る
    var name = scan.nextLine();
    var path = Paths.get(name);

    if (Files.exists(path) == false) { // ファイル存在有無
      try {
        Files.createFile(path); // ファイル作成
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try (scan){
      System.out.println(Files.getLastModifiedTime(path));  // 最終更新日取得
      System.out.println(Files.getPosixFilePermissions(path)); // アクセス権取得

      System.out.println("delete y/n? >");
      if ("y".equals(scan.nextLine())) {
        Files.delete(path); // 削除
        System.out.println("delete");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
