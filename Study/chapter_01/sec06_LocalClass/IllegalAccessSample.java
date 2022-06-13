package sec06_LocalClass;

/** ローカルクラスの使用例 */
public class IllegalAccessSample {

    /* ローカルクラスを定義したメソッド内のローカル変数にアクセス */
    public void test() {
        String name = "sample";
        class Sample {
            public void hello() {
                System.out.printf("Hello %s%n", name);
            }
        }
        new Sample().hello();
    }

    /* ローカルクラスの定義後にローカル変数を宣言してコンパイルエラー */
    public void testNg() {
        class Sample {
            public void hello() {
//                System.out.printf("Hello %s%n", name);  // コンパイルエラー ※1
            }
        }
        String name = "sample";
        new Sample().hello();
    }

    /* 実質的 final なローカル変数の値を変更してコンパイルエラー */
    public void testNgChangeValue() {
        String name = "sample";
        class Sample {
            public void hello() {
                System.out.printf("Hello %s%n", name);
            }
        }
//        name = "test";  // コンパイルエラー ※2
        new Sample().hello();
    }
}

/**
 * <pre>
 * ローカルクラスは、そのクラスを定義したメソッド内のローカル変数にアクセスすることができる
 *   - ※1 ローカルクラスが参照するローカル変数は、ローカルクラスの定義よりも前に宣言されて
 *        いなければならない
 *   - ※2 ローカルクラス内から参照するローカル変数は、実質的 final でなければならない
 * </pre>
 */
