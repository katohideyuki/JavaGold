package sec09_LowerBoudedWildcard;

import debug.Debug;

/** 下限境界ワイルドカード */
public class UseTest {
    public static void main(String[] args) {
        creTest();
    }

    /* Test 型のインスタンス生成 */
    private static void creTest() {
        Debug.log("creTest");
        Test<? super B> a   = new Test<A>(new A());
        Test<? super B> b   = new Test<B>(new B());
//        Test<? super B> c = new Test<C>(new C());  // B 以上じゃないとダメなのでコンパイルエラー

        a.setVal(new B());
        b.setVal(new C());
//        a.setVal(new A());   // A は B のサブクラスじゃないのでコンパイルエラー

        // フィールド値の型が不定のため、Object 型となる
        Object obj   = a.getVal();
        Object obj_2 = b.getVal();
        System.out.printf(" obj : %s%n obj_2 : %s%n", obj, obj_2);

        // ダウンキャストすれば、任意の型で取り出せるが、非推奨
        A obj_A = (A) a.getVal();
        B obj_B = (B) b.getVal();
        System.out.printf(" obj_A : %s%n obj_B : %s%n", obj_A, obj_B);
    }
}

/**
 * <pre>
 * 下限境界ワイルドカード
 *   - 戻り値型は Object 型のみとなる
 *   - メソッドの引数は任意の型にできる
 *     - ジェネリクスを宣言するとき、super を使って、型パラメータの下限を決めること
 *       - Test<? super B> test;
 *       - 上記のように宣言すると、「B もしくはその親型の型パラメータを受け取れる」
 * </pre>
 */
