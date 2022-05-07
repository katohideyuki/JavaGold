package sec17_ReentrantLock;

/** ReentrantLock クラスの使用例
      - スレッドの実行順序が保証されていない */
public class RandomOrderTask implements Runnable {
    private Test test;

    /* コンストラクタ */
    public RandomOrderTask(Test test) {
        super();
        this.test = test;
    }

    @Override /* タスク - 順番通りにメソッドを呼び出す想定
                       - 複数スレッドが絡むと 順番が保証されない */
    public void run() {
        test.first();
        test.second();
        test.third();
    }
}
