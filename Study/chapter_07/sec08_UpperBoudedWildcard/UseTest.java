package sec08_UpperBoudedWildcard;

import debug.Debug;

/** 上限境界ワイルドカード */
public class UseTest {
    public static void main(String[] args) {
        creTest();
    }

    /* Test 型のインスタンス生成 */
    private static void creTest() {
        Debug.log("creTest");
        Test<? extends B> test = new Test<B>(new B());      // B クラスなので OK
        B b = test.getVal();
        b.hello();

        Test<? extends B> test_2 = new Test<C>(new C());    // B のサブクラスなので OK
        B c = test_2.getVal();
        c.hello();

//        Test<? extends B> test_3 = new Test<A>(new A());  // Bのサブクラス以下ではないため、コンパイルエラー
//        test.setVal(new B());                             // 引数は null のみなのでコンパイルエラー
    }
}

/**
 * <pre>
 * 上限境界ワイルドカード
 *   - メソッドの引数は null のみとなる
 *   - 戻り値型は 任意の型にできる
 *     - ジェネリクスを宣言するとき、extends を使って、型パラメータの上限を決めること
 *       - Test<? exetend B> test;
 *       - 上記のように宣言すると、「B もしくはそのサブクラス型の型パラメータを受け取れる」
 * </pre>
 */