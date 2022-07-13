package file_related;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import debug.Debug;

public class LogIO {

    static final Path BASE_IN      = Path.of("src/main/resource/file_related/in_file");   // 読み込みディレクトリ
    static final Path BASE_OUT     = Path.of("src/main/resource/file_related/out_file");  // 読み込みディレクトリ
    static final String IN_SUFFIX  = "_hoge.log";                                         // 読み込みファイル名の接尾辞
    static final String OUT_SUFFIX = "_fuga.log";                                         // 書き込みファイル名の接尾辞

    public static void main(String[] args) throws IOException {
        advancePreparation();
        fileIO();
    }

    /**
     * baseディレクトリ内部のファイルを一つずつ読み込み、新しいファイルに追記していく
     */
    private static void fileIO() throws IOException {
        Debug.log("fileIO");

        // BASE_IN ディレクトリ内部のファイル一覧を取得し、ソートする
        List<Path> fileList = Files.list(BASE_IN).collect(Collectors.toList());
        Collections.sort(fileList);

        // ファイル一覧をひとつずつ読み込み、新しいファイルへ書き込む
        int count = 0;
        for (Path path : fileList) {

            // 書き込むファイルパス
            count++;
            Path filePath = BASE_OUT.resolve(count + OUT_SUFFIX);

            // ファイルが存在しなければ、生成
            if (Files.exists(filePath) == false)
                Files.createFile(filePath);

            // 読み込みと書き込み(追記)
            try (BufferedReader in = Files.newBufferedReader(path);
                    BufferedWriter out = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND)) {

                // 書き込みメソッド呼び出し
                in.lines().forEach(str -> outFile.accept(str, out));
            }
        }
    }

    /**
     * debug
     * 書き込む文字列と、出力先ファイルを受け取り、書き込み処理を行う
     */
    private static final BiConsumer<String, BufferedWriter> outFile = (str, out) -> {
        try {
            out.write(str);
            out.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    /**
     * debug
     * 読み込み必要なファイルを予め10ファイル生成
     */
    private static void advancePreparation() throws IOException {
        Debug.log("advancePreparation");

        for (int i = 1; i <= 10; i++) {
            Path filePath = BASE_IN.resolve(i + IN_SUFFIX);   // ファイルパス

            // ファイルが存在すれば処理を終了し、次のファイルを確認
            if (Files.exists(filePath) == true)
                continue;

            Files.createFile(filePath);                       // ファイル生成
            try (BufferedWriter out = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND);) {
                out.write(i + "つ目のファイルです。");
                out.newLine();
            }
        }
        Files.list(BASE_IN).forEach(System.out::println);     // baseディレクトリ内部のファイルを出力
    }
}
