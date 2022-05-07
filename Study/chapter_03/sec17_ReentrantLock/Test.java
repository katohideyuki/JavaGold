package sec17_ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/** ReentrantLock クラスの使用例
      - 順番に実行される想定のメソッドを定義 */
public class Test {
    private final ReentrantLock lock = new ReentrantLock();

    /* 1番目に実行するメソッド */
    public void first() {
        System.out.printf("%s : 1 %n", Thread.currentThread().getId());
    }

    /* 2番目に実行するメソッド */
    public void second() {
        System.out.printf("%s : 2 %n", Thread.currentThread().getId());
    }

    /* 3番目に実行するメソッド */
    public void third() {
        System.out.printf("%s : 3 %n", Thread.currentThread().getId());
    }

    /* ロック ※1 */
    public void lock() {
        this.lock.lock();
    }

    /* アンロック */
    public void unlick() {
        this.lock.unlock();
    }
}

/**
 * <pre>
 * ※1
 * lock メソッドを呼び出したスレッドが unlock メソッドを呼び出すまで、
 * 別のスレッドによる lock メソッドの呼び出しを待機させる
 * </pre>
 */