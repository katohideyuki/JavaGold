package chapter_16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 入出力<br>
 * Files.newbufferedWriter/newBufferedReaderメソッド<br>
 * いろいろ試そうとして、コードがめちゃくちゃになったので、後日整形<br>
 * 【問題点】 - BufferedReaderのインスタンスを追記前に生成(createIO.accept)しているため、追記分が出力されない<br>
 * - フィールドにBufferedWriter/Readerを定義しているため、tryWithResourceで閉じれない（スコープ）
 */
public class SampleNewBuffered {
  private static Path samplePath = Paths.get("dir", "sample.txt");
  private static BufferedWriter out;
  private static BufferedReader in;

  public static void main(String[] a) {
    fileIOExecution();
  }

  private static void fileIOExecution() {
    // ファイルが存在し無ければ生成
    if (!existsPath.test(samplePath)) {
      try {
        Files.createFile(samplePath);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    createIO.accept(samplePath);
    var scan = new Scanner(System.in);
    try (scan) {
      System.out.println("> ");
      // 書き込み
      out.write(scan.nextLine());
      out.newLine();
      // 読み込み
      in.lines().forEach(x -> System.out.println(x));
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        out.close();
        in.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private static Predicate<Path> existsPath = x -> Files.exists(x); // 存在有無チェック
  // BufferedWrite/Reader インスタンス生成用
  private static Consumer<Path> createIO = (samplePath) -> {
    try {
      in = Files.newBufferedReader(samplePath);
      out = Files.newBufferedWriter(samplePath, StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }
  };
}
