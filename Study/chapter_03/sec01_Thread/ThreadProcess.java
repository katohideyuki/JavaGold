package sec01_Thread;

/** 新しい Thread の使用例 */
public class ThreadProcess extends Thread {
    @Override
    public void run() {
        System.out.println("sub");
    }
}

/**
 * <pre>
 * 新しい Thread を実行するには、Thread クラスを継承し、
 * run メソッドをオーバーライドして、そこに処理内容を記述する
 * </pre>
 */