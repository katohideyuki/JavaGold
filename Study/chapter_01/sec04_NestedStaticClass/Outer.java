package sec04_NestedStaticClass;

/** ネストした static なクラス */
public class Outer {
    private String message     = "Hello, Java";
    private static String name = "Goodbye, Java";

    /** インナークラス */
    class Inner {

        /* エンクロージングクラスのフィールドを出力 */
        public void test() {
            System.out.println(message);    // OK
            System.out.println(name);       // OK
        }
    }

    /** ネストした static なクラス */
    static class InnerStatic {

        /* エンクロージングクラスのフィールドを出力 */
        public void test() {
//            System.out.println(message);  // NG : 非 static なフィールドにできないため、コンパイルエラー
            System.out.println(name);       // OK
        }
    }
}

/**
 * <pre>
 * ネストしたクラスからエンクロージングクラスのメンバにアクセスできるが、
 * ネストした static なクラスからエンクロージングクラスの非 static なフィールドやメソッド
 * にはアクセスできない
 *   - static の仕組みによるもの
 *       - static で修飾されたフォールドやメソッドは、クラスがロードされたタイミングで static 領域
 *         に配置され、インスタンスを生成しなくても、すぐに使用可能になる。
 *         一方、非 static なフィールドやメソッドは、ヒープ領域にインスタンスを生成して初めて使える。
 *         このように、配置されるメモリ領域や使えるタイミングが違うため、static なメソッドから
 *         非 static なフィールドやメソッドにアクセスすることができない
 * </pre>
 */