package sec16_Enum;

import debug.Debug;

/** Enum の使用例 */
public class UseTest {
    public static void main(String[] args) {
        useTestExe(Test.A);
        useTestWithArgs();
        useQuestion_15();
    }

    /* 列挙子 A のインスタンス化の検証 */
    private static void useTestExe(Test test) {
        Debug.log("useTestExe");
        System.out.println(Test.A == test);         // true ※1
    }

    /* 引数ありの列挙子 A のインスタンス化の検証 */
    private static void useTestWithArgs() {
        Debug.log("useTestWithArgs");
        System.out.println(TestWithArguments.A);    // hoge
    }

    /* 設問15の検証 */
    private static void useQuestion_15() {
        Debug.log("useQuestion_15");
        System.out.println(Question_15.A);          // hello が4回出力される
    }

}

/**
 * <pre>
 * Enum
 *   - Enum が使用されるとき、列挙子が1つずつインスタンス化される
 *     - Enum に定義されている列挙子のインスタンスは、それが使用されるタイミングで
 *       JVMが自動的に生成する
 *     - ※1 列挙子のインスタンスは1つしか存在しないようになっているため、true となる
 *   - Enum に定義するコンストラクタのアクセス修飾子は、private でなくてはならない
 *     - アクセス修飾子を省略した場合、暗黙的に private であると解釈される
 * </pre>
 */
