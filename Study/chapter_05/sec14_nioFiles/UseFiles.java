package sec14_nioFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import debug.Debug;
import fileRelated.DelDir;

/** nio.file.Files の使用例 - resolve */
public class UseFiles {
    static final String BASE_PATH = "src/main/resource/chapter_05/sec14";   // 作業ディレクトリ
    static final Path DIR         = Paths.get(BASE_PATH, "dir", "subdir");  // ディレクトリパス
    static final Path FILE        = DIR.resolve("sec14_sample.txt");        // ファイルパス

    public static void main(String[] args) throws IOException {
        useCreateDirectories();
        del();
        useCreateDirectory();
    }

    /* ディレクトリとファイルを作成 - Files.createDirectories */
    private static void useCreateDirectories() throws IOException {
        Debug.log("useCreateDirectories");
        // ディレクトリ作成
        if (! Files.exists(DIR))
            System.out.printf("create directory %n  => %s%n", DIR);
        Files.createDirectories(DIR);
        // ファイル作成
        if (! Files.exists(FILE)) {
            System.out.printf("create file %n  => %s%n", FILE);
            Files.createFile(FILE);
        }
    }

    /* ディレクトリとファイルを作成 - Files.createDirectory */
    private static void useCreateDirectory() throws IOException {
        Debug.log("useCreateDirectory");
        // ディレクトリ作成
        if (! Files.exists(DIR))
            System.out.printf("create directory %n  => %s%n", DIR);
        Files.createDirectory(DIR);
        // ファイル作成
        if (! Files.exists(FILE)) {
            System.out.printf("create file %n  => %s%n", FILE);
            Files.createFile(FILE);
        }
    }

    /* debug - sec14 で生成したディレクトリとファイルを削除する */
    private static void del() throws IOException {
        System.out.print("""

                *********************************************
                If you don't delete directory and file,
                you'll get an exception int the next method.
                delete directory and file for sec14? (y/n)
                *********************************************
                >
                """);
        // y であれば subdir を再帰的に削除し useCreateDirectory は成功する
        // n であれば 同名のディレクトリが存在するため useCreateDirectory は失敗する
        try (Scanner scan = new Scanner(System.in)) {
            if ("y".equals(scan.nextLine()))
                DelDir.exe(DIR);
        }
    }
}

/**
 * <pre>
 * Files.createDirectories(Path 型)
 *   - ディレクトリを生成
 *   - 親ディレクトリが存在しなくてもサブディレクトリを生成する
 *   - 同名のディレクトリが既に存在する場合は、何もしない
 * ※ 厳密な操作が必要ないのであれば、こっちを使う
 *
 * Files.createDirectory(Path 型)
 *   - ディレクトリを生成
 *   - 親ディレクトリが存在しなければ NoSuchFileException をスロー
 *   - 同名のディレクトリが既に存在する場合も NoSuchFileException をスロー
 *
 * Paths.resolve(String 型)
 *   - ディレクトリだけを表すパスと、ファイルを表すパスを別々に作り、必要に応じて結合する
 *
 * </pre>
 */