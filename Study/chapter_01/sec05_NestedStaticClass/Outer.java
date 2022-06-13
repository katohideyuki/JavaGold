package sec05_NestedStaticClass;

/** ネストした static なクラス
      - 非 static なインナークラスに　static なフィールド、メソッドは定義できない */
public class Outer {

    /* インナークラスのフィールドに値を代入 */
    void test() {
        Inner.message = "Hello, Java";
    }

    /** 非 static なインナークラス */
    class InnerNG {
//        private static String message;  // コンパイルエラー
    }

    /** ネストした static なクラス */
    static class Inner {
        private static String message;

        /* フィールドを出力 */
        public void test() {
            System.out.println(message);
        }
    }
}

/**
 * <pre>
 * 非 static なインナークラスには、static なフィールドやメソッドを定義することはできない
 *   - ネストした static なクラスにしか定義できない
 *       - ネストした static なクラスには、static、非 static どちらも定義できる
 * </pre>
 */