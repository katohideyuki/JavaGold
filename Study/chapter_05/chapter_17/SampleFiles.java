package chapter_17;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;

/**
 * 入出力<br>
 * Files.list/walk/find/newDirectoryStreamメソッド<br>
 *
 */
public class SampleFiles {
  private static Path base = Paths.get(".");

  public static void main(String[] a) {
    try {
      getListStream();
      getList();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * StreamAPIを利用したファイル取得の例<br>
   * - list/walk/find<br>
   *
   * @throws IOException
   */
  private static void getListStream() throws IOException {
    Files.list(base).forEach(x -> System.out.println(x)); // ファイル一覧取得（サブディレクトリ含まない）
    System.out.println("---");

    Files.walk(base.resolve("src")).forEach(x -> System.out.println(x)); // ファイル一覧取得（サブディレクトリ含む）
    System.out.println("---");

    BiPredicate<Path, BasicFileAttributes> bp = (path, attr) -> {
      return path.toFile()/* ファイル変換 */.getName().endsWith("PNG");
    };
    Files.find(base, 3/* 深さ */, bp/* 絞り込み条件 */).forEach(x -> System.out.println(x)); // 条件で絞り込んだファイル一覧を取得（サブディレクトリ含む）
    System.out.println("---");
  }

  /**
   * StreamAPIを利用しないファイル取得の例<br>
   * - newDirectoryStream<br>
   *
   * @throws IOException
   */
  private static void getList() throws IOException {
    DirectoryStream<Path> dirs = Files.newDirectoryStream(base);
    for (Path p : dirs) {
      System.out.println(p.getFileName());
    }
  }
}
