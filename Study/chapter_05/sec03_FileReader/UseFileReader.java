package sec03_FileReader;

import java.io.File;
import java.io.FileReader;

import debug.Debug;
import fileRelated.FileFactory;

/** FileReader の使用例 */
public class UseFileReader {
    static final File FILE = new File("src/main/resource/chapter_05/sec03/sec03_sample.txt");

    public static void main(String[] args) {
        readFile(FILE);
    }

    /* ファイルから文字を読み込む */
    private static void readFile(File file) {
        Debug.log("readFile");
        FileReader reader = FileFactory.creFileReader(file);
        try (reader){
            int i = 0;
            while ((i = reader.read()) != -1) {
                char c = (char) i;
                System.out.print(c);
            }
        } catch (Exception e) {
            System.out.printf("readFile failure : %s%n", e);
        }
    }
}

/**
 * <pre>
 * FileReader
 *   - 文字入力ストリームを扱うため、ファイルから文字を読み込む
 *   - 不要になったストリームは閉じる必要がある
 *     - FileReader.close()
 *     - try-with-resource を使うこと
 *
 * FileReader.read()
 *   - 1文字単位で読み込む
 *   - ファイル内の全ての文字を読み込んだら、終端を表すため「-1」を返却
 *   - 何らかの理由で正常に読み込めなかったら、IOException をスロー
 * </pre>
 */