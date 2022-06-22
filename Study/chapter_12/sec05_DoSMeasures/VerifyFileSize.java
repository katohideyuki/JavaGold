package sec05_DoSMeasures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/** DoS攻撃 - 読み込むファイルサイズを制限 */
public class VerifyFileSize {
    static final int FILE_SIZE_LIMIT = 100;
    static final String FILE_NAME    = "GoodSample.txt";

    public static void main(String[] a) throws IOException {
        exe(FILE_NAME);
    }

    /* ファイルを読み込む前にファイルサイズの制限をする */
    private static void exe(String fileName) throws IOException {
        long fileSize = Files.size(Paths.get(fileName));

        // ファイルサイズが上限を超えていたら、例外をスロー
        if (fileSize > FILE_SIZE_LIMIT)
            throw new IOException(String.format("File too large : %s%n", fileSize));

        // ファイルサイズが0だったら、例外をスロー
        if (fileSize == 0L)
            throw new IOException(String.format("File size cannot be determined : %s%n", fileSize));

        // ファイルサイズに問題がなければ OK メッセージを出力
        System.out.println("File size OK");
    }
}

/**
 * <pre>
 * DoS攻撃の対策の一貫として、ファイルの読み込む際にファイルサイズを制限する
 *   - 予め上限を規定しておけば、予想外のファイルサイズを読み込み、メモリを使い果たすことを避ける
 *   - ファイルからテキストを読み込む時、BufferedReader を使って1行ずつデータを読み込むのが
 *     一般的
 *        - 1行ずつとは、文字列の中で改行(¥n)か復帰(¥r)、または復帰とそれに続く改行(¥r¥n)
 *          が表れるまでの文字列を指す。
 *          そのため、これら改行コードがない、非常に長い行を持ったファイルを読み込ませることで、
 *          メモリを使い果たす可能性がある
 * </pre>
 */
