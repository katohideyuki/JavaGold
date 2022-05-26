package sec16_nioFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.Path;
import java.util.Scanner;

import debug.Debug;

/** nio.file.Files の使用例 - newBufferedReader, Writer */
public class UseBufferedReadWrite {
    static final Path FILE = Path.of("src/main/resource/chapter_05/sec16/sec16_sample.txt");

    public static void main(String[] argas) throws IOException {
        readAfterWrite();
    }

    /* ファイルを書き込んだあと、読み込む */
    private static void readAfterWrite() throws IOException {
        Debug.log("readAfterWrite");
        // ファイルが存在しなければ作成
        if (Files.exists(FILE) == false) {
            Files.createFile(FILE);
            System.out.printf("create file completed %n  => %s%n", FILE);
        }
        // コンソールから入力を受け付け、ファイルに書き込む
        Scanner scan       = new Scanner(System.in);
        BufferedWriter out = Files.newBufferedWriter(FILE, StandardOpenOption.APPEND);
        try (scan; out) {
            System.out.print("Add to file > ");
            out.write(scan.nextLine());
            out.newLine();
        }
        // 書き込んだファイルを読み込む
        BufferedReader in = Files.newBufferedReader(FILE);
        try (in) {
            System.out.println("\n▼ file reading completed");
            in.lines().forEach(System.out::println);
        }
    }
}

/**
 * <pre>
 * Files.newBufferedReader
 *   - バッファから読み込むためのストリームをつくる
 *
 * Files.newBufferedWriter
 *   - バッファから書き込むためのストリームをつくる
 *
 * nio.file.StandardOpenOption
 *   - ファイルを開く場合や作成する場合などのオプションを指定する
 *     - APPEND          : 追記
 *     - CREATE          : ファイルが存在しない場合に、新規作成
 *     - CREATE_NEW      : 新規作成し、既にファイルが存在する場合は失敗
 *     - DELETE_ON_CLESE : 閉じるときに削除
 *     - READ            : 読み込みアクセス用に開く
 * </pre>
 */