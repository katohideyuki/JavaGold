package sec15_Atomic;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import debug.Debug;
import threadRelated.Sleep;

/** Atomic */
public class UseAtomic {
    public static void main(String[] a) {
        useValue();
        Sleep.exe(1000);
        useAtomicValue();
    }

    /* 2つスレッドを実行し、Value.num フィールドの値が10,000になる想定
         - 競合が発生し、10,000にならない */
    private static void useValue() {
        Debug.log("useValue");
        Value value = new Value();
        ThreadExeHelper(value);
    }

    /* 2つスレッドを実行し、Value.num フィールドの値が10,000になる */
    private static void useAtomicValue() {
        Debug.log("useAtomicValue");
        Value value = new AtomicValue();
        ThreadExeHelper(value);
    }

    /* debug - スレッドを実行し、処理結果を出力する */
    private static void ThreadExeHelper(Value value) {
        ExecutorService exec = Executors.newCachedThreadPool();

        // 処理結果を出力
        CyclicBarrier barrier = new CyclicBarrier(2, () -> {
            exec.shutdown();
            System.out.printf("expected value : 10000 %n  => resulet value : %s%n"
                    , value.getNum());
        });

        // スレッド実行
        exec.submit(new Task(value, barrier));
        exec.submit(new Task(value, barrier));
    }
}
