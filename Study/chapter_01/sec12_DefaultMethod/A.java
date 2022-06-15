package sec12_DefaultMethod;

/** デフォルトメソッドの使用例
      - インタフェースのデフォルトメソッドと、通常のクラスが同じメソッドを定義していた場合 */
public interface A {
    default void test() {
        System.out.println("A");
    }
}
