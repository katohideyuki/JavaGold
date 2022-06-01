package sec07_UnboudedWildcard;

import debug.Debug;

/** 非境界ワイルドカード */
public class UseTest {
    public static void main(String[] args) {
        creInstance();
    }

    /* Test 型のインスタンス生成 */
    private static void creInstance() {
        Debug.log("creInstance");
        Test<?> test = new Test<>("Hello");
        String msg   = (String) test.getValue();  // Object 型から String 型へダウンキャスト
        System.out.println(msg);

        test.setValue(null);                      // null は特殊な型なので OK
//        test.setValue("sample");                // Test 型のフィールド値の型が不定のため、コンパイルエラー
//        test.setValue(new Object());            // Test 型のフィールド値の型が不定のため、コンパイルエラー
        System.out.println(test.getValue());
    }
}

/**
 * <pre>
 * 非境界ワイルドカード
 *   - メソッドの引数は null のみとなる
 *   - 戻り値型は Object 型のみとなる
 *     - コンパイラは、どのような型のインスタンスへの参照が入っているか
 *       特定できないため
 *     - Object 型以外の戻り値型にしたい場合、ダウンキャストすれば可能
 *       - ただし、実行時に例外が発生する可能性があるため、非推奨の方法
 * </pre>
 */
