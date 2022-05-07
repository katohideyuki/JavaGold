package sec17_ReentrantLock;

/* ReentrantLock クラスの使用例
     - スレッドの実行順序が保証されている */
public class InOrderTask implements Runnable {
    private Test test;

    /* コンストラクタ */
    public InOrderTask(Test test) {
        this.test = test;
    }

    @Override /* タスク - 順番通りにメソッドを呼び出す想定 */
    public void run() {
        try {
            test.lock();    // スレッドがロックを取得
            test.first();
            test.second();
            test.third();
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        } finally {
            test.unlick();  // スレッドがロックを解除 ※1
        }
    }
}

/**
 * <pre>
 * ※1 このタイミングで、次のスレッドがロックを取得できる
 * </pre>
 */