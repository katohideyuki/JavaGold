package sec09_Scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import debug.Debug;

/** Scanner　の使用例 */
public class UsePostalCode {
    static final String FILE_PATH = "src/main/resource/chapter_05/sec09/KAGAWA.csv";
    static final String DELETE_STR = "\"";  // 削除対象の文字

    public static void main(String[] args) throws FileNotFoundException {
        creList();
    }

    /* KAGAWA.csv の読み込みからテキスト処理を行う */
    private static void creList() throws FileNotFoundException {
        Debug.log("creList");
        List<PostalCode> list = new ArrayList<>();
        FileInputStream fis   = new FileInputStream(FILE_PATH);
        Scanner scanner       = new Scanner(fis);
        scanner.useDelimiter(",|¥n");   // 区切り文字を「カンマと改行」に設定

        // 必要な情報を PostalCode のコンストラクタに渡す
        try (scanner) {
            while (scanner.hasNext()) {
                scanner.next();   																          // skip : 全国地方公共団体コード
                scanner.next();   																          // skip : 郵便番号(5桁)
                String code       = delStrHelper(scanner.next());           // 郵便番号(7桁)
                scanner.next();   																          // skip : 都道府県 半角カタカナ
                scanner.next();                                             // skip : 市区町村名 半角カタカナ
                scanner.next();   																          // skip : 町域名 半角カタカナ
                String prefecture = delStrHelper(scanner.next());           // 都道府県名
                String disrict    = delStrHelper(scanner.next());           // 市区町村名
                String town       = delStrHelper(scanner.next());           // 町域名
                list.add(new PostalCode(code, prefecture, disrict, town));  // データ追加
            }
        }
        list.forEach(System.out::println);
    }

    /* debug - 指定文字を削除する */
    private static String delStrHelper(String str) {
        return str.replaceAll(DELETE_STR, "");
    }
}

/**
 * Scanner
 *   - 読み込んだ文字列を処理するメソッドを持つ
 *
 * Scanner.useDelimiter(区切り文字する文字列)
 *   - 区切り文字を設定する
 *
 * Scanner.next()
 *   - 指定された区切り文字で分割された文字列を1つ返却
 *   - 要素がないのに next メソッドを呼ぶと、NoSuchElementException をスローする
 *
 */
