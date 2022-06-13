package sec07_AnonymousClass;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;

import debug.Debug;

/** 匿名クラスの使用例 */
public class ListSample {
    public static void main(String[] args) {
        outLog();
        uniqueMethodAnonymityNG();
        uniqueMethodAnonymity();
    }

    /* メソッドをオーバーライドし、一時的なクラスとして定義した匿名クラス */
    private static void outLog() {
        Debug.log("outLog");
        /** 受け取った引数をログに出力する */
        List<String> list = new ArrayList<>() {
            Logger logger = System.getLogger("sample");
            @Override
            public boolean add(String value) {
                logger.log(Level.INFO, String.format("ADD LOG : %s%n", value));
                return super.add(value);
            }
        };
        list.add("A");
        list.add("B");
        list.add("C");
    }

    /* 独自メソッドを定義した匿名クラス - コンパイルエラー ※1 */
    private static void uniqueMethodAnonymityNG() {
        Debug.log("uniqueMethodAnonymityNG");
        /** Object 型で参照し、独自メソッドを定義する */
        Object obj = new Object() {
            public void test() {
                System.out.println("test");
            }
        };
//        obj.test();   // コンパイルエラー : Object 型に test メソッドがないと判断されている
    }

    /* 独自メソッドを定義した匿名クラス - 変数 obj を var で型推論するようにする */
    private static void uniqueMethodAnonymity() {
        Debug.log("uniqueMethodAnonymity");
        /** var 型で型推論し、独自メソッドを定義する */
        var obj = new Object() {
            public void test() {
                System.out.println("test");
            }
        };
        obj.test();
    }
}

/**
 * <pre>
 * 匿名クラス
 *   - 既存のクラスの一部分だけをオーバーライドした一時的なクラスを
 *     つくるときにも使える
 *   - ※1 インタフェースやスーパークラスにない、独自のメソッドを定義するこも可能
 *       - ただし、代入する型は var を使った変数宣言で行うこと
 * </pre>
 */
