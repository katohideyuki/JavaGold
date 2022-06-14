package sec09_InterfaceMethod;

import debug.Debug;

/** インタフェースの static メソッド */
public class InterfaceStaticMethod {
    public static void main(String[] args) {
        useTest();
    }

    /* インタフェースに定義してある test メソッドを呼び出す */
    private static void useTest() {
        Debug.log("useTest");
        A.test();
//        B.test();   // コンパイルエラー
//        C.test();   // コンパイルエラー
    }
}

/**
 * <pre>
 * Java SE 8 からインタフェースに static メソッドを定義できるようになった
 *   - クラスに定義する static メソッドとの違いは、呼び出し時に継承したサブインタフェースや
 *     実現したクラスの名前を使うことができず、必ず定義したインタフェース名を使う必要がある
 * </pre>
 */
