package sec10_InterfaceMethod;

import debug.Debug;

/** インタフェースの static メソッド */
public class CannotOverride implements Sample{
    public static void main(String[] args) {
        useTest();
    }

    /* インタフェースに定義された static メソッドと同名のメソッドを定義しても
       オーバーライドにならない ※1 */
    public static void test() {
        System.out.println("B");
    }

    private static void useTest() {
        Debug.log("useTest");
        // Sample インタフェースの test メソッドを実行
        System.out.print("This is Sample interface's test method : ");
        Sample.test();
        // CannotOverride クラスの test メソッドを実行
        System.out.print("This is CannotOverride's test method : ");
        test();
    }
}

/**
 * <pre>
 * static メソッドはオーバーライドできない
 *   - 従って、インタフェースに定義された static メソッドもオーバーライドはできない
 *
 * ※1 @override アノテーションを付けたら、コンパイルエラーになる
 * </pre>
 */
