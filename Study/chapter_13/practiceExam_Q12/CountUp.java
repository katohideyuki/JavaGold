package practiceExam_Q12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import debug.Debug;
import threadRelated.Sleep;

/** Q.12 スレッドセーフ */
public class CountUp {
    private static AtomicInteger num = new AtomicInteger();

    public static void main(String[] args) {
        countUp();
    }

    /* スレッドプールを10生成して、10000 * 10回インクリメントする */
    private static void countUp() {
        Debug.log("countUp");
        ExecutorService service = Executors.newFixedThreadPool(10);

        // スレッドを10回実行する
        for (int i = 0; i < 10; i++) {
            service.submit(() -> {
               // num フィールドを10,000回インクリメント
               for (int j = 0; j < 10_000; j++) {
                   num.incrementAndGet();   // Atomic 用のインクリメント
               }
            });
        }
        Sleep.exe(1000);                    // スレッドが終わる用に1秒待機する
        service.shutdown();
        System.out.println(num.intValue());
    }
}


/**
 * <pre>
 * 変数 num をづレッドセーフにするには、 synchronized を使って排他制御を行うか、
 * AtomicInteger などのマルチスレッドに対応可能なプリミティブ型のラッパークラスを
 * 利用する
 *   - パフォーマンスへの影響を抑えながら、排他制御を実現する
 *
 * マルチスレッドによる並列処理では、各スレッドがフィールドの値のキャッシュを持つ
 * スレッドが、ヒープ上にあるインスタンスを参照せずに処理を進めれられるため、
 * パフォーマンスが向上するのが理由
 *   - メリットがある一方、スレッドが持っている値と、インスタンスのフィールドでの
 *     値にズレが生じてしまう可能性がある
 *
 * synchronized
 *   - どのインスタンスをロックするかを指定しなければいけない
 *
 * volatile
 *   - フィールドを修飾すると、キャッシュされずに安全に扱えるようになる
 *   - 値を取得するとき、最新の値を取得する　※ スレッドセーフになるわけではない
 * </pre>
 */
