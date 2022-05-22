package sec06_BufferedWriter;

import java.io.BufferedWriter;
import java.io.IOException;

import debug.Debug;
import fileRelated.FileFactory;

/** BufferedWriter の使用例 */
public class UseBufferedWruter {
    static final String FILE_PATH = "src/main/resource/chapter_05/sec06/sec06_sample.txt";

    public static void main(String[] args) throws IOException {
        appendFile();
    }

    /* テキストファイルへ書き込み */
    private static void appendFile() throws IOException {
        Debug.log("appendFile");
        BufferedWriter out = FileFactory.creBufferedWriter(FILE_PATH);
        try (out) {
            out.newLine();
            out.write("buffering output");
            out.flush();
        }
    }
}

/**
 * <pre>
 * BufferedWriter
 *   - 文字出力ストリーム
 *
 * BufferedWriter.newLine()
 *   - 改行コードを出力
 * BufferedWriter.write()
 *   - ファイルに直接書き込まず、バッファに書き込む
 *     - 稀に、バッファに書き込まれた最新データと実際のファイルのデータが食い違うタイミングができる時がある
 * BufferedWriter.flush()
 *   - バッファ内のデータがファイルへと出力され、メモリとファイルの同期を行う
 * </pre>
 */