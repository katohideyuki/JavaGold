package sec01_File;

import java.io.File;
import java.io.IOException;

import debug.Debug;

/** File の使用例 */
public class UseFile {
    static final File FILE = new File("src/main/resource/chapter_04/sec01/sec01_sample_01.txt");
    static final File DIR  = new File("src/main/resource/chapter_04/sec01/sec01_sample_01.txt");

    public static void main(String[] args) {
        fileExists();
        dirExists();
        getDirPath();
    }

    /* ファイルの存在有無を確認 */
    private static void fileExists() {
        Debug.log("fileExists");
        try {
            // ファイルが存在しなければ、空のファイルを生成
            if (! FILE.exists()) {
                System.out.println("Not found : sec01_sample_01.txt ");
                FILE.createNewFile();
                return;
            }
            System.out.printf("file already exists : %s%n", FILE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* ディレクトリの存在有無を確認 */
    private static void dirExists() {
        Debug.log("dirExists");
        // ディレクトリが存在しなければ、空のディレクトリを生成
        if (! DIR.exists()) {
            System.out.println("Not found : makeDir_01");
            DIR.mkdir();
            return;
        }
        System.out.printf("Directory already exists : %s%n", DIR);
    }

    /* ディレクトリの絶対パスを取得 */
    private static void getDirPath() {
        Debug.log("getDirPath");
        System.out.printf("File path      : %s%n", FILE.getAbsolutePath());
        System.out.printf("Directory path : %s%n" , DIR.getAbsolutePath());
    }
}

/**
 * File.exists()
 *   - ファイルが存在すれば true
 *
 * File.createNewFile()
 *   - 空のファイルを生成
 *
 * File.mkdir()
 *   - 空のディレクトリを生成
 *
 * File.getAbsolutePath()
 *   - 絶対パスを取得
 */