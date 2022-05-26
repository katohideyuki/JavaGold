package sec15_nioFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import debug.Debug;

/** nio.File.Files の使用例 - copy, move */
public class UseCopyAndMove {
    static final Path BASE_PATH      = Paths.get("src/main/resource/chapter_05/sec15/"); // 作業ディレクトリパス
    static final Path FROM_FILE_PATH = BASE_PATH.resolve("sec15_sample.txt");            // コピー元パス
    static final Path TO_COPY_PATH   = BASE_PATH.resolve("sec15_sample_bk.txt");         // コピー元パス
    static final Path TO_MOVE_PATH   = BASE_PATH.resolve("dir/sec15_new_sample.txt");    // 移動先パス

    public static void main(String[] args) throws IOException {
        fileCopyAndMove();
    }

    /* ファイルのコピー&移動 */
    private static void fileCopyAndMove() throws IOException {
        Debug.log("fileCopyAndMove");
        // sec15 で作成したファイルを予め削除する
        delFile();
        // ファイルが存在しなければ、ファイル作成
        if (Files.exists(FROM_FILE_PATH) == false) {
            Files.createFile(FROM_FILE_PATH);
            System.out.printf("create file completed %n  => %s%n", FROM_FILE_PATH);
        }
        // コピー先に同名ファイルが存在しなければ、ファイルコピー
        if (Files.exists(TO_COPY_PATH) == false) {
            Files.copy(FROM_FILE_PATH, TO_COPY_PATH);
            System.out.printf("file copy completed %n  => %s%n", TO_COPY_PATH);
        }
        // 移動先に同名ファイルが存在しなければ、ファイル移動
        if (Files.exists(TO_MOVE_PATH) == false) {
            Files.move(FROM_FILE_PATH, TO_MOVE_PATH);
            System.out.printf("file move completed %n  => %s%n", TO_MOVE_PATH);
        }
    }

    /* debug - sec15 で生成したファイルを削除する */
    private static void delFile() throws IOException {
        // ファイル削除
        if (Files.exists(FROM_FILE_PATH))
            Files.delete(FROM_FILE_PATH);
        // ファイル削除
        if (Files.exists(TO_COPY_PATH))
            Files.delete(TO_COPY_PATH);
        // ファイル削除
        if (Files.exists(TO_MOVE_PATH))
            Files.delete(TO_MOVE_PATH);

        System.out.println("deleted sec15 related files \n");
    }
}

/**
 * <pre>
 * Files.copy(Path 型のコピー元, path 型のコピー先)
 *   - ファイルをコピーする
 *
 * Files.move(Path 型のコピー元, path 型のコピー先)
 *   - ファイルを移動する
 * </pre>
 */