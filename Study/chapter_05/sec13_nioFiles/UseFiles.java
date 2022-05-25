package sec13_nioFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import debug.Debug;

/** nio.file.Files の使用例 */
public class UseFiles {

    // 以下ディレクトリ配下でファイル操作する
    static final String PREFIX = "src/main/resource/chapter_05/sec13";  // ファイルパス
    static final String SUFFIX = ".txt";                                // 拡張子

    public static void main(String[] args) throws IOException {
        tryUseFilesRelated();
    }

    /* Files.XXX メソッドをあれこれ使ってみる
         - コンソールから入力を受け付け => ファイル作成 => ファイル情報出力 => ファイル削除 */
    private static void tryUseFilesRelated() throws IOException {
        Debug.log("tryUseFilesRelated");

        // コンソールから入力を受け付ける
        System.out.print("Please enter the file name (no extension) > ");
        try (Scanner scan = new Scanner(System.in)) {
            String fileName = scan.nextLine();

            // ファイルが存在しなければ、新規作成
            Path path = Paths.get(PREFIX, fileName + SUFFIX);
            if (! Files.exists(path)) {
                Files.createFile(path);
                System.out.printf("created file %n  => %s%n%n", path);
            }

            // ファイル情報出力
            System.out.printf("Last Modified : %s%n", Files.getLastModifiedTime(path));
            System.out.printf("Access rights : %s%n%n", Files.getPosixFilePermissions(path));

            // 再びコンソールから入力を受け付け、「y」であればファイルを削除
            System.out.print("delete this file? (y/n) > ");
            if ("y".equals(scan.nextLine())) {
                Files.delete(path);
                System.out.printf("delete file %n  => %s%n%n", path);
            }
        }
    }
}

/**
 * <pre>
 * Files.exists(Path 型)
 *   - ファイルが存在するか否かを Boolean 型で返却
 *
 * Files.createFile(Path 型)
 *   - ファイルを新規作成
 *   - ファイルが既に存在する場合、FileAlreadyExistsException をスローする
 *
 * Files.getLastModifiedTime(Path 型)
 *   - ファイルの最終更新日時を保持した FileTime 型を返却
 *
 * Files.getPosixFilePermission(Path 型)
 *   - ファイルのアクセス権限を調べる
 *
 * Files.delete(Path 型)
 *   - ファイル削除
 *
 * Files.deleteIfExists(Path 型)
 *   - ファイルが存在すれば、削除する
 * </pre>
 */