package sec11_DefaultMethod;

/** インタフェースのデフォルトメソッドの使用例 */
public interface B {
    default void test() {
        System.out.println("B");
    }
}
