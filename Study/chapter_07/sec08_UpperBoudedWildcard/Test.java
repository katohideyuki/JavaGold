package sec08_UpperBoudedWildcard;

/** 上限境界ワイルドカード */
public class Test<T> {
    T val;

    /* コンストラクタ */
    public Test(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }
}
