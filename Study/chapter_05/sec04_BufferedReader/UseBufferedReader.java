package sec04_BufferedReader;

import java.io.BufferedReader;
import java.io.IOException;

import debug.Debug;
import fileRelated.FileFactory;

/** BufferedReader の使用例 */
public class UseBufferedReader {
    static final String FILE_PATH  = "src/main/resource/chapter_05/sec04/sec04_sample.txt";
    static final BufferedReader READER = FileFactory.creBufferedReader(FILE_PATH);

    public static void main(String[] args) throws IOException {
        outputFile();
    }

    /* 一行ずつファイルを読み込む - bufferedReader.readLine */
    private static void outputFile() throws IOException {
        Debug.log("outputFileUseStream");
        try (READER) {
            READER.lines().forEach(System.out::println);
        }
    }
}

/**
 * <pre>
 * BufferedReader(FileReader インスタンス)
 *   - 単体では動作せず、コンストラクタで受け取った Reader を通じてファイルへアクセス
 *
 * BufferedReader.readLine()
 *   - 一行ずつ文字列を読み込む
 *   - テキストが終端に達したら null を返却
 * </pre>
 */
