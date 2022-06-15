package sec13_DefaultMethod;

/** デフォルトメソッドの使用例
      - インタフェースのデフォルトメソッドと、抽象クラスが同じメソッドを定義した場合 */
public interface A {
    public default void test() {
        System.out.println("A");
    }
}
