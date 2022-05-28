package sec17_nioFiles;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;

import debug.Debug;

/** nio.file.Files の使用例 - walk */
public class UseWalk {
    static final Path BASE_PATH = Path.of("src/main/resource/chapter_05/sec17/dir");  // 作業ディレクトリ

    public static void main(String[] args) throws IOException {
        outPath();
        outAllPath();
        outConditionsPath();
        outPathWithoutUseStream();
    }

    /* 指定したディレクトリ内を出力 - list */
    private static void outPath() throws IOException {
        Debug.log("outPath");
        Files.list(BASE_PATH).forEach(System.out::println);
    }

    /* サブディレクトリを含む、すべてのパスを出力 - walk */
    private static void outAllPath() throws IOException {
        Debug.log("outAllPath");
        Files.walk(BASE_PATH).forEach(System.out::println);
    }

    /* 指定した条件に合致したモノのみ出力 - find */
    private static void outConditionsPath() throws IOException {
        Debug.log("outWithConditions");
        // 拡張子が「.txt」であれば true
        BiPredicate<Path, BasicFileAttributes> isText = (path, attr) -> {
            return path.toFile().getName().endsWith(".txt");
        };
        Files.find(BASE_PATH, 3, isText).forEach(System.out::println);
    }

    /* StreamAPI を利用しないファイル取得の例 - newDirectoryStream */
    private static void outPathWithoutUseStream() throws IOException {
        Debug.log("outPathWithoutUseStream");
        DirectoryStream<Path> dirs = Files.newDirectoryStream(BASE_PATH);
        for (Path path : dirs)
            System.out.println(path.getFileName());
    }
}

/**
 * <pre>
 * Files.list(Path 型)
 *   - ディレクトリ内のパスを取得
 *   - サブディレクトリの中は対象外
 *   - StreamAPI を利用するなら有効
 *
 * Files.walk(Path 型)
 *   - サブディレクトリを含むすべてのパスを取得
 *
 * Files.find(Path 型, 探索するディレクトリの深さ, BiPredecate 型の絞り込み条件)
 *   - 条件で絞り込む
 *
 * Files.newDirectoryStream(Path 型)
 *   - ディレクトリ内のパスを取得
 *   - 拡張for を利用するなら有効
 * </pre>
 */