package sec12_nioPath;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import debug.Debug;

/** nio.file.Path の使用例 */
public class UsePath {
    static final String FILE_PATH = "src/main/resource/chapter_05/sec12/sec12_sample.txt";

    public static void main(String[] args) {
        getPath();
        getPathFromMultiStr();
        getPathFromFile();
        getFileFromPath();
        getAbsolutePath();
    }

    /* ファイルパスを取得 */
    private static void getPath() {
        Debug.log("getPath");
        Path path = Paths.get(FILE_PATH);
        System.out.printf("file path of sec12_sample.txt : %s%n", path);
    }

    /* ファイルパスを取得 - 可変長引数でパスを指定 */
    private static void getPathFromMultiStr() {
        Debug.log("getPathFromMultiStr");
        Path path = Paths.get("src", "main", "resource", "chapter_05", "sec12", "sec12_sample.txt");
        System.out.printf("file path of sec12_sample.txt : %s%n", path);
    }

    /* File から Path を取得 */
    private static void getPathFromFile() {
        Debug.log("getPathFromFile");
        Path path = new File(FILE_PATH).toPath();
        System.out.printf("file path of sec12_sample.txt : %s%n", path);
    }

    /* Path から File を取得 */
    private static void getFileFromPath() {
        Debug.log("getFileFromPath");
        File file = Paths.get(FILE_PATH).toFile();
        System.out.printf("file path of sec12_sample.txt : %s%n", file);
    }

    /* Path から絶対パスを取得 */
    private static void getAbsolutePath() {
        Debug.log("getAbsolutePath");
        Path path = Paths.get(FILE_PATH);
        System.out.printf("absolute path of sec12_sample.txt : %s%n", path.toAbsolutePath());
    }
}

/**
 * <pre>
 * nio.file.Path
 *   - ファイルやディレクトリへのパスを表す
 *
 * nio.file.Files
 *   - ファイル操作関連
 *
 * nio.file.Paths
 *   - Path を利用しやすくするヘルパークラス
 *
 * Paths.get(String 型の可変長のファイルパス...)
 *   - 複数の文字列をシステムが稼働するプラットフォームの種類に応じたパス区切り文字を挟みながら連結してくれるため、
 *     プラットフォームの違いを意識する必要がない
 *
 * File.toPath()
 *   - File 型から Path を取得する
 *     - nio.file.Files から Path は取得できない
 *
 * Path.toAbsolutePath()
 *   - Path 型から絶対パスを取得
 * </pre>
 */