package sec05_FileWriter;

import java.io.FileWriter;
import java.io.IOException;

import debug.Debug;

/** FileWriter の使用例 */
public class UseFileWriter {
    static final String FILE_PATH    = "src/main/resource/chapter_05/sec05/sec05_sample.txt";
    static final String FILE_PATH_02 = "src/main/resource/chapter_05/sec05/sec05_sample_01.txt";

    public static void main(String[] args) throws IOException {
        overWriteFile();
        appendFile();
    }

    /* テキストファイルへ書き込み - 上書き (第二引数を指定していないため) */
    private static void overWriteFile() throws IOException {
        Debug.log("writeFile");
        FileWriter out = new FileWriter(FILE_PATH);
        try (out) {
            out.write("Hello Java!");
            System.out.printf("Completed writing : %s%n", FILE_PATH);
        }
    }

    /* テキストファイルへ書き込み - 追記 (第二引数に true を指定しているため) */
    private static void appendFile() throws IOException {
        Debug.log("appnedFile");
        FileWriter out = new FileWriter(FILE_PATH_02, true);
        try (out) {
            out.write("\n"); // 改行
            out.write("Hello Java!");
            System.out.printf("Completed writing : %s%n", FILE_PATH_02);
        }

    }
}

/**
 * <pre>
 * FileWriter(ファイルパス)
 *   - テキストファイルへの書き込みに使う
 *   - コンストラクタに指定した出力先のファイルが存在しない場合、新たなファイルを生成
 *   - 第二引数を指定すると、上書き or 追記 を選択できる
 *     - true                : 追記
 *     - false または 指定なし : 上書き
 *   - 指定したファイルパスと同名のディレクトリが存在した場合
 *     FileNotFoundException をスローする
 *
 * FileWriter.write()
 *   - 書き込みを実行
 * </pre>
 */