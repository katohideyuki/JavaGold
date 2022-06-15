package sec11_DefaultMethod;

/** インタフェースのデフォルトメソッドの使用例 */
public interface A {
    default void test() {
        System.out.println("A");
    }
}
