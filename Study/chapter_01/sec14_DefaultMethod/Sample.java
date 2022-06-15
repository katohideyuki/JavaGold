package sec14_DefaultMethod;

/** インタフェースの private メソッドの使用例 */
public interface Sample {

    /* デフォルトメソッド */
    default void test() {
        System.out.println("test");
        testHelper();
    }

    /* デフォルトメソッドから呼ばれることが前提の private メソッド */
    private void testHelper() {
        System.out.println("test");
    }
}

/**
 * <pre>
 * Java SE 8 で追加されたデフォルトメソッドをより簡潔にする目的で、
 * Java SE 9 ではインタフェースに private メソッドを追加できるようになった
 *   - default 修飾子は必要なし
 *   - インタフェースのデフォルトメソッドから呼ばれることが前提
 *   - 処理内容を記述すること
 *     - 記述しなければ抽象メソッドと見なされ、アクセス修飾子を public にする必要がでてくるため
 * </pre>
 */
