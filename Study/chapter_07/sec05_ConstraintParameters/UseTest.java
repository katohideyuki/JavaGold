package sec05_ConstraintParameters;

import debug.Debug;

/** 制約付き型パラメータ */
public class UseTest {
    public static void main(String[] args) {
        creInstance();
    }

    /* 総称型を使用する側 */
    private static void creInstance() {
        Debug.log("creInstance");
        Test<A> a = new Test<>();  // A クラスなので OK
        Test<B> b = new Test<>();  // A クラスを継承しているため OK
//        Test<C> c = new Test<>(); // Aクラスを継承していないため、コンパイルエラー

        a.execute(new A());
        a.execute(new B());
        b.execute(new B());
    }
}
