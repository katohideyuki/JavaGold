package chapter_18;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

/**
 * 入出力<br>
 * - walkFileTreeメソッド/SimpleFileVisitor/FileVisitorResultクラスなど<br>
 *
 */
public class SampleWalkFileTree {
  public static void main(String[] args) {
    try {
      fileVisitoExecution();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * ディレクトリ、ファイルを準備したあと、それらを削除する<br>
   * @throws IOException
   */
  private static void fileVisitoExecution() throws IOException {
    Path dir = Paths.get("dir", "data");
    List<String> fileNameList = Arrays.asList("a.txt", "b.txt", "c.txt");
    // ディレクトリが無ければ生成
    if (Files.exists(dir) == false) {
      Files.createDirectories(dir);
    }
    // ファイル生成
    fileNameList.stream().forEach(fileName -> creFile(dir, fileName));
    Files.list(dir).forEach(x -> System.out.println(x));

    // ファイル、ディレクトリ削除
    Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Files.delete(file);
        return FileVisitResult.CONTINUE;
      }
    });
    Files.delete(dir);
    System.out.println("deleted");
  }

  /**
   * ファイル生成メソッド<br>
   * - ファイルが存在しなければ生成<br>
   *
   * @param dir
   * @param fileName
   */
  private static void creFile(Path dir, String fileName) {
    try {
      if (Files.exists(dir.resolve(Paths.get(fileName))) == false) {
        Files.createFile(dir.resolve(Paths.get(fileName)));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
