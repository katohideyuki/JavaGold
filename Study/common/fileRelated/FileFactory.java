package fileRelated;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/** 例外処理を記述すると冗長になるため File 型に関するインスタンス生成などを切り離す
      - 現時点で何が汎用性高いのか判断つかないため、必要なときに必要な処理を追加していき
        終盤でリファクタリングを行う */
public class FileFactory {
    // 読み込み用デフォルトファイル
    static final String DEFAULT_READ_PATH  = "src/main/resource/chapter_05/default.txt";
    // 書き込み用デフォルトファイル
    static final String DEFAULT_WRITE_PATH = "src/main/resource/chapter_05/default_write.txt";

    /* FileReader インスタンスを返却
         - ファイルが存在しなければデフォルトのFileReader インスタンスを返却 */
    public static FileReader creFileReader(File file) {
        try {
            if (file.exists())
                return new FileReader(file);
            return new FileReader(new File(DEFAULT_READ_PATH));
        } catch (FileNotFoundException e) {
            System.out.printf("file not found : %s%n", file);
            throw new RuntimeException(e);
        }
    }

    /* BufferedReader インスタンスを返却
         - ファイルが存在しなければデフォルトの BufferedReader インスタンスを返却 */
    public static BufferedReader creBufferedReader(String path) {
        File file = new File(path);
        try {
            if (file.exists())
                return new BufferedReader(new FileReader(file));
            return new BufferedReader(new FileReader(new File(DEFAULT_READ_PATH)));
        } catch (IOException e) {
            System.out.printf("file not found : %s%n", path);
            throw new RuntimeException(e);
        }
    }

    /* BufferedWriter インスタンスを返却
         - 同名のディレクトリが存在していれば、デフォルトの BufferedWriter インスタンスを返却 */
    public static BufferedWriter creBufferedWriter(String path) {
        File file = new File(path);
        try {
            if (!file.isDirectory()) {
                System.out.printf("written to file : %s%n", file);
                return new BufferedWriter(new FileWriter(file, true));
            }
            System.out.printf("written to default file : %s%n", DEFAULT_WRITE_PATH);
            return new BufferedWriter(new FileWriter(DEFAULT_WRITE_PATH, true));
        } catch (IOException e) {
            System.out.printf("same name already exists : %s%n", path);
            throw new RuntimeException(e);
        }
    }

    /* ディレクトリ生成 */
    public static void creDir(Path dir) throws IOException {
        if (Files.exists(dir) == false) {
            System.out.printf("create directory %n  => %s%n", dir);
            Files.createDirectories(dir);
        }
    }

    /* ファイル生成 */
    public static void creFile(Path file) throws IOException {
        if (Files.exists(file) == false) {
            System.out.printf("create file %n  => %s%n", file);
            Files.createFile(file);
        }
    }
}