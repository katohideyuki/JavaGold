package fileRelated;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/** 例外処理を記述すると冗長になるため File 型に関するインスタンス生成などを切り離す */
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

}