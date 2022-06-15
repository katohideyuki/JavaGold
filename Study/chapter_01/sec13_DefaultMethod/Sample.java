package sec13_DefaultMethod;

import debug.Debug;

/** デフォルトメソッドの使用例
      - インタフェースのデフォルトメソッドと、抽象クラスが同じメソッドを定義した場合 */
public class Sample extends B implements A {
    public static void main(String[] args) {
        useTest();
    }

    /* B 抽象クラスの test メソッドを実行 */
    private static void useTest() {
        Debug.log("useTest");
        new Sample().test();
    }
}
