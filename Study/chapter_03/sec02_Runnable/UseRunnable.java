package sec02_Runnable;

/** Runnable インターフェースの使用例 */
public class UseRunnable {
    public static void main(String[] args) {
        creThreadAnonymous();
        creThreadLambda();
    }

    /* Runnable を実現した匿名クラスで、新しいスレッドを作る */
    private static void creThreadAnonymous() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("'sub'  of creThreadAnonymous");
            }
        });
        t.start();
        System.out.println("'main' of creThreadAnonymous");
    }

    /* ラムダ式で新しいスレッドを作る */
    private static void creThreadLambda() {
        Thread t = new Thread(() -> System.out.println("'sub'  of creThreadLambda"));
        t.start();
        System.out.println("'main' of creThreadLambda");
    }
}

/**
 * <pre>
 * 新しいスレッドを作る方法
 *   1. Thread クラスを継承したサブクラスを定義  ※ chapter_01.sec01 で紹介
 *   2. Runnable インターフェースを実現したクラスを用意し、Thread クラスのコンストラクタに渡す
 *        - Runnable インターフェースは run メソッドのみ持っている
 * </pre>
 */