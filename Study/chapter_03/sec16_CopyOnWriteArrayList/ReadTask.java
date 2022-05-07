package sec16_CopyOnWriteArrayList;

import java.util.List;

import threadRelated.Sleep;

/** CopyOnWriteArrayList
      - リストの要素を読み出すタスクを持つ */
public class ReadTask implements Runnable {
    private List<Integer> list;

    /* コンストラクタ */
    public ReadTask(List<Integer> list) {
        this.list = list;
    }

    @Override /* タスク */
    public void run() {
        System.out.println("--------- read START ");
        // 例外発生する可能性あり ※1
        try {
            for (Integer val : list) {
                Sleep.exe(100);
                System.out.printf("read : %s%n", val);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--------- read END ");
    }
}

/**
 * <pre>
 * ※1
 * ArrayListを使った拡張for文では、読み出しをしている際に追加や削除によって
 * コレクション内の要素数を変更すると、ConcurrentModificationExceptionが
 * スローされる
 * </pre>
 */
