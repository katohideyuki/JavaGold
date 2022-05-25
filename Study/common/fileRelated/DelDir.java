package fileRelated;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/** 再帰的にディレクトリの中身を削除する */
public class DelDir extends SimpleFileVisitor<Path> {

    public static void exe(Path delPath) throws IOException {
        Files.walkFileTree(delPath, new DelDir());
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        return delete(file);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return delete(dir);
    }

    private FileVisitResult delete(Path delPath) {
        try {
            Files.deleteIfExists(delPath);
            System.out.printf("delete '%s'%n", delPath);
            return FileVisitResult.CONTINUE;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
