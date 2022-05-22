package fileRelated;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/** 例外処理を記述すると冗長になるため File 型に関するインスタンス生成などを切り離す
      - 現時点で何が汎用性高いのか判断つかないため、必要なときに必要な処理を追加していき
        終盤でリファクタリングを行う */
public class FileFactory {
    private static final String DEFAULT_PATH = "src/main/resource/chapter_05/default.txt";

    /* FileReader インスタンスを返却
         - ファイルが存在しなければデフォルトのFileReader インスタンスを返却 */
    public static FileReader creFileReader(File file) {
        try {
            if (file.exists())
                return new FileReader(file);
            return new FileReader(new File(DEFAULT_PATH));
        } catch (FileNotFoundException e) {
            System.out.printf("file not found : %s%n", e);
            throw new RuntimeException(e);
        }
    }

    /* BufferdReader インスタンスを返却
         - ファイルが存在しなければデフォルトのBufferedReader インスタンスを返却 */
    public static BufferedReader creBufferedReader(String path) {
        File file = new File(path);
        try {
            if (file.exists())
                return new BufferedReader(new FileReader(file));
            return new BufferedReader(new FileReader(new File(path)));
        } catch (IOException e) {
            System.out.printf("file not found : %s%n", e);
            throw new RuntimeException(e);
        }
    }

}
