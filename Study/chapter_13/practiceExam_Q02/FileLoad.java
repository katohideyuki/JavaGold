package practiceExam_Q02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import debug.Debug;

/** Q.02 - Files.Linesメソッドの戻りはStream型 */
public class FileLoad {
    static final String FILE_NAME = "src/main/resource/chapter_13/sec02/FruitList.txt";

    public static void main(String[] args) throws IOException {
        exe();
        getFruits();
    }

    /* ファイル読み込み後に Stream オブジェクトを取得できるもの */
    private static void exe() throws IOException {
        Debug.log("exe");
        var a = Files.lines(Paths.get(FILE_NAME));                // Stream を返却
        var b = Files.readAllLines(Paths.get(FILE_NAME));         // List を返却
//        Stream<String> c = Files.lines(FILE_NAME);              // コンパイルエラー
//        String<String> d = readAllLines(Paths.get(FILE_NAME));  // コンパイルエラー

        System.out.println(a);
        System.out.println(b);
    }

    /* 「g」から始まる果物のみ出力 */
    private static void getFruits() throws IOException {
        Debug.log("getFruits");
        try (Stream<String> in = Files.lines(Paths.get(FILE_NAME))) {
            in.filter(fruit -> fruit.charAt(0) == 'g').forEach(System.out::println);
        }
    }
}

/**
 * Files.lines(読み込むPathオブジェクト)
 *   - ファイル内のすべての行を読み込み、Stream を返却
 *
 * Files.readAllLines(読み込むPathオブジェクト)
 *   - ファイル内のすべての行を読み込み、List を返却
 */