package sec12_DefaultMethod;

import debug.Debug;

/** デフォルトメソッドの使用例
      - インタフェースのデフォルトメソッドと、通常のクラスが同じメソッドを定義していた場合 */
public class UseC {
    public static void main(String[] args) {
        useTest();
    }

    /* B クラスで定義された test メソッドを実行 */
    private static void useTest() {
        Debug.log("useTest");
        A a = new C();
        a.test();   // B
    }
}

/**
 * <pre>
 * インタフェースに定義しているメソッドと同じシグニチャのメソッドをクラスに定義されている上で、
 * そのインタフェースとクラスを継承したクラスが、その同じシグニチャのメソッドを呼び出す場合
 * スーパークラスのメソッドが優先的に呼び出される
 * </pre>
 */
