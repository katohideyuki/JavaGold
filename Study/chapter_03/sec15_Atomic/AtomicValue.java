package sec15_Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/** Atomic - Value クラスを継承し、原子性を担保する */
public class AtomicValue extends Value {
    private AtomicInteger num = new AtomicInteger();

    public void add(int num) {
        this.num.addAndGet(num);
    }

    public int getNum() {
        return this.num.intValue();
    }
}

/**
 * <pre>
 * AtomicInteger.addAndget(int val)
 *   - 読み出しから値の変更までの一連の動作中に他のスレッドからの処理を受け付けないようにする
 *
 * AtomicInteger.intValue()
 *   - AtomicInteger が保持する値を取得する
 * </pre>
 */