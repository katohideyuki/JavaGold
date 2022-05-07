package sec13_Synchronized;

import debug.Debug;
import threadRelated.Sleep;

/** 排他制御 - synchronized キーワードの使用例 */
public class UseSynchronized {
    public static void main(String[] args) {
        useConflictThread();
        Sleep.exe(1000);
        useSynchronized();
    }

    /* 競合するプログラム */
    private static void useConflictThread() {
        Debug.log("useConflictThread");
        System.out.print("expected value : 10000\n  => resulet value : ");
        ConflictThread.exe();
    }

    /* 競合しないプログラム */
    private static void useSynchronized() {
        Debug.log("useSynchronized");
        System.out.print("expected value : 10000\n  => resulet value : ");
        SyncThread.exe();
    }
}
