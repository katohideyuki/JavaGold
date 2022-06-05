package sec12_FIFO;

import java.util.ArrayDeque;
import java.util.Deque;

import debug.Debug;

/** Deque の使用例 */
public class UseDeque {
    public static void main(String[] args) {
        outValue();
    }

    /* コレクションに先頭 or 末尾 から追加し出力する */
    private static void outValue() {
        Debug.log("outValue");
        Deque<Character> deque = new ArrayDeque<>();
        deque.addLast('A');
        deque.addLast('B');
        deque.addFirst('C');
        deque.addFirst('D');
        deque.stream().forEach(System.out::println);
    }
}

/**
 * <pre>
 * Deque
 *   - 末尾と先頭の両方から入れて、両方から取り出せるコレクション
 *
 * Deque.addLast
 *   - 末尾からキューに追加
 *
 * Deque.addFirst
 *   - 先頭からキューに追加
 * </pre>
 */
