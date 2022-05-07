package sec16_CopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import debug.Debug;
import threadRelated.Sleep;

/** CopyOnWriteArrayList */
public class UseCopyOnWriteArrayList {
    public static void main(String[] args) {
        conflictList();
        Sleep.exe(1000);
        useCopyOnWriteArrayList();
    }

    /* 競合するリスト - 例外発生 ※1 */
    private static void conflictList() {
        Debug.log("conflictList");
        List<Integer> list = new ArrayList<>();
        processHelper(list);
    }

    /* 競合しないリスト ※1 */
    private static void useCopyOnWriteArrayList() {
        Debug.log("useCopyOnWriteArrayList");
        List<Integer> list = new CopyOnWriteArrayList<>();
        processHelper(list);
        System.out.printf("add value => %s", list);  // WriteTask実行後のリストを出力
    }

    /* debug - スレッドを実行し、処理結果を出力  */
    private static void processHelper(List<Integer> list) {

        // 初期値として1~3の値を追加
        for (int i = 1; i <= 3; i++)
            list.add(i);

        // スレッド実行
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.submit(new WriteTask(list));
        exec.submit(new ReadTask(list));

        // 3秒後にスレッド終了し、処理結果を出力
        Sleep.exe(3000);
        exec.shutdown();
    }
}

/**
 * ※1
 * CopyOnWruteArrayList
 *   - 読み出しをする際にコピーを作ることで、読み込みと書き出しを同時に行っても
 *     例外が発生することはない
 *       - ただし、コレクションの要素のコピーを取って読み出すため、
 *         追加された要素は表示されない
 */