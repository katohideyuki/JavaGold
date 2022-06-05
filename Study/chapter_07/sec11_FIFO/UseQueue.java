package sec11_FIFO;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import debug.Debug;

/** Queue の使用例 */
public class UseQueue {
    public static void main(String[] args) {
        outValue();
        usePool();
    }

    /* コレクションに追加した順から取得 - Queue */
    private static void outValue() {
        Debug.log("outValue");
        Queue<Character> queue = creQueueHelper();
        queue.stream().forEach(System.out::println);
    }

    /* 追加した値を取得し削除する - Queue.pool */
    private static void usePool() {
        Debug.log("usePool");
        Queue<Character> queue = creQueueHelper();

        System.out.printf("first  value : %s%n", queue.poll());
        System.out.printf("second value : %s%n", queue.poll());
        System.out.printf("Contents of the current collection : %s%n", queue);
    }

    /* debug - A 〜 E の文字が順番に追加された Queue を返却する */
    private static Queue<Character> creQueueHelper() {
        List<Character> list = Arrays.asList('A', 'B', 'C', 'D', 'E');
        return list.stream().collect(Collectors.toCollection(ArrayDeque::new));
    }
}

/**
 * <pre>
 * FIFO
 *   - First-In First-Out : 先入れ先出し
 *   - 最初に格納した要素を最初に取り出すことのできる仕組みを提供するデータ構造
 *
 * Queue.pool
 *   - 先頭の要素を取得し、そのあと削除する
 *   - 取り出した要素は、コレクションから無くなる
 *
 * Collectors.toCollection()
 *   - コレクションに変換する
 *   - コレクションインスタンスを生成する関数を渡す
 * </pre>
 */
