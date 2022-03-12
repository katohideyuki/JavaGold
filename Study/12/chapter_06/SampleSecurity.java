package chapter_06;

import java.io.FilePermission;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Permissions;
import java.security.Policy;
import java.util.function.Consumer;

/**
 * セキュアコーディング<br>
 */
public class SampleSecurity {
  public static void main(String[] a) {
    getDirList_Good();
    getDirList_Bad();
    getDirList_NotAccess();
  }

  /**
   * ルートディレクトリの一覧表示<br>
   * - ルートディレクトリのみ読み込み可能にして、アクセス制限を有効にする<br>
   */
  private static void getDirList_Good() {
    System.out.println("SampleSecurity.getDirList_Good()--------------");

    Permissions permissions = new Permissions();
    permissions.add(new FilePermission("/", "read")); // ルートディレクトリに読み込み権限を付与
    Policy.setPolicy(new SamplePolicy(permissions)); // ポリシーを設定
    System.setSecurityManager(new SecurityManager());

    printList.accept("/");
  }

  /**
   * ルートディレクトリの一覧表示<br>
   * - アクセス制限がないので、セキュリティ上問題<br>
   */
  private static void getDirList_Bad() {
    System.out.println("SampleSecurity.getDirList_Bad()--------------");

    printList.accept("/");
  }

  /**
   * ルートディレクトリの一覧表示<br>
   * - アクセス制限を有効にする<br>
   * - 有効にしただけでは、すべての場所にアクセスできなくなる<br>
   */
  private static void getDirList_NotAccess() {
    System.out.println("SampleSecurity.getDirList_NotAccess()--------------");

    System.setSecurityManager(new SecurityManager()); // セキュリティ機構を有効にして、アクセス制限をかける
    printList.accept("/");
  }

  /* パスを文字列で受け取り、その直下にあるディレクトリ,ファイルを出力する */
  private static Consumer<String> printList = path -> {
    try {
      Files.list(Paths.get(path)).forEach(p -> System.out.println(p.getFileName()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  };

}
