package sec18_nioSimpleFileVisitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import debug.Debug;
import fileRelated.FileFactory;

/** nio.file.SimpleFileVisitor の使用例 - walkTree */
public class UseWalkFileTree {
    static final Path BASE_PATH  = Path.of("src/main/resource/chapter_05/sec18");
    static final Path DELETE_DIR = BASE_PATH.resolve("dir/subdir"); // 削除対象のディレクトリ

    public static void main(String[] args) throws IOException {
        recursivelyDeleted();
    }

    /* 指定したディレクトリとその中にあるファイルを再帰的に削除
         ※ サブディレクトリの削除はできない - walkFileTree */
    private static void recursivelyDeleted() throws IOException {
        Debug.log("recursivelyDeleted");
        creDirAndFile();

        // 現在のディレクトリ一覧を出力
        Files.walk(BASE_PATH).forEach(System.out::println);
        // ディレクトリ内にファイルがあると削除できないため、先にファイルを削除する
        Files.walkFileTree(BASE_PATH, new SimpleFileVisitor<Path>() {
            @Override /* ファイルに遭遇したら、そのファイルを削除する */
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }
        });
        // 削除対象のディレクトリを削除
        Files.delete(BASE_PATH.resolve("dir/subdir"));
        System.out.println("delete completed");
    }

    /* debug - sec18 で利用するディレクトリ & ファイルを生成 */
    private static void creDirAndFile() throws IOException {
        FileFactory.creDir(DELETE_DIR);
        FileFactory.creFile(DELETE_DIR.resolve("A.txt"));
        FileFactory.creFile(DELETE_DIR.resolve("B.txt"));
        FileFactory.creFile(DELETE_DIR.resolve("C.txt"));
    }
}

/**
 * <pre>
 * Files.walkFileTree()
 *   - 指定されたディレクトリ内を再帰的に移動しながら、処理を行う
 *   - どのような処理を行うかは、nio.file.FileVisitor インターフェースの抽象メソッドで定義
 *     - ディレクトリに入るとき      : preVisitDirectory()
 *     - ファイルに遭遇したとき      : visitFile()
 *     - ファイルの処理に失敗したとき : visitFileFailed()
 *     - ディレクトリから出るとき    : postVisitDerectory()
 *
 * SimpleFIleVisitor
 *   - FileVisitor インターフェースの抽象メソッドを最低限オーバーライドしてくれる
 *     - 引数の null チェックを行い、null なら例外をスローし、
 *       そうでなければ FileVisitResult.CONTINUE を返却
 *
 * FileVisitResult
 *   - 各メソッドが返却する定数
 *     - ファイル探索を継続 : CONTINUE
 *     - 終了             : TERMINATE
 * </pre>
 */