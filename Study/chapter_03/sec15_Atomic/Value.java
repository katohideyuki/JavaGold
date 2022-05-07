package sec15_Atomic;

/** Atomic - 原子性が担保されないクラス */
public class Value {
    private int num = 0;

    public void add(int num) {
        this.num += num;
    }

    public int getNum() {
        return num;
    }
}
