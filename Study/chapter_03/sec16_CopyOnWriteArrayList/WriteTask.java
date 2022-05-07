package sec16_CopyOnWriteArrayList;

import java.util.List;

import threadRelated.Sleep;

/** CopyOnWriteArrayList
      - リストの要素に書き込むタスクを持つ */
public class WriteTask implements Runnable {
    private List<Integer> list;

    /* コンストラクタ */
    public WriteTask(List<Integer> list) {
        this.list = list;
    }

    @Override /* タスク - 10~19の値を追加 */
    public void run() {
        for (int i = 10; i < 20; i++) {
            Sleep.exe(100);
            list.add(i);
        }
    }
}
