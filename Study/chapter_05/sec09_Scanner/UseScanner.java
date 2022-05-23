package sec09_Scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import debug.Debug;

/** Scanner　の使用例 */
public class UseScanner {
    static final String FILE_PATH = "src/main/resource/chapter_05/sec09/sec09_sample.txt";
    public static void main(String[] args) throws FileNotFoundException {
        readFile();
    }

    /* ファイルを一行ずつ読み込む - デフォルトの区切り文字のため、空白でも区切られる */
    private static void readFile() throws FileNotFoundException {
        Debug.log("readFile");
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Scanner scanner = new Scanner(fis);
        try (scanner) {
            while (scanner.hasNext())
                System.out.println(scanner.next());
        }
    }
}

/**
 * <pre>
 * Scanner
 *   - 文字入トストリームを簡単に扱える
 *   - 読み込んだ文字列を処理するメソッドを持っている
 *   - デフォルトの区切り文字は「空白、タブ、改行コード」
 *
 * Scanner.hasNext()
 *   - 次に読み込むべき行があるか確認しながら、next メソッドで一行ずつ読み込む
 * </pre>
 */