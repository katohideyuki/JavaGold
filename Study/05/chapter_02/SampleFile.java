package chapter_02;

import java.io.File;
import java.io.FileFilter;

/**
 * 入出力<br>
 * - listFiles/isDirectory/acceptメソッド/FileFilterインターフェース<br>
 *
 */
public class SampleFile {
  private static final File FILE = new File(".");

  public static void main(String[] a) {
    executeFile();
  }

  private static void executeFile() {
    System.out.println("▼ listFileメソッド");
    showTree(FILE);

    System.out.println("▼ isDirectoryメソッド");
    showTree(FILE, "");

    System.out.println("▼ FileFilterインターフェース");
    /**
     * FileFilterインターフェースのaccept抽象メソッドをラムダ式で実現 ※Consumer型のacceptとは異なる
     * 通常このインターフェースを実装したクラスのインスタンスは、 Fileクラスの listFiles メソッドに渡されます
     * listFilesメソッドの処理でファイルの取捨選別が必要になった場合に accept がコールバックされます
     **/
    FileFilter filter = (path) -> {
      if (path.isDirectory()) {
        return true;
      } else if (path.getName().endsWith("java")) {
        return true;
      }
      return false;
    };
    showTree(FILE, filter, "");
  }

  /**
   * ILEインスタンスに対して、listFilesメソッド実行<br>
   * - 結果の並び順は保証されていない<br>
   *
   * @param dir
   */
  private static void showTree(File dir) {
    File[] files = dir.listFiles(); // 一覧取得
    for (File file : files) {
      System.out.println(file.getName());
    }
  }

  /**
   * FILEインスタンスに対して、isDirectoryメソッド実行<br>
   * - ディレクトリがあればtrue<br>
   *
   * @param dir
   * @param str
   */
  private static void showTree(File dir, String str) {
    File[] files = dir.listFiles();
    for (File file : files) {
      System.out.println(str + file.getName());
      if (file.isDirectory()) {
        showTree(file, str + " "); // 再帰（メソッド内で、自分自身のメソッドを呼ぶ）
      }
    }
  }

  /**
   * FILEインスタンスに対して、FileFilterインターフェースを使用<br>
   *
   * @param dir
   * @param filter
   * @param str
   */
  private static void showTree(File dir, FileFilter filter, String str) {
    File[] files = dir.listFiles();
    for (File file : files) {
      System.out.println(str + file.getName());
      if (file.isDirectory()) {
        showTree(file, filter, str + "");
      }
    }
  }

}
