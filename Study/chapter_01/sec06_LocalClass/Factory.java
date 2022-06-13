package sec06_LocalClass;
/** ローカルクラスの使用例 */
public class Factory {

    /* Test インタフェースを実現した Hello ローカルクラスを Test 型で返却 */
    public static Test hello() {

        /** Hello ローカルクラス */
        class Hello implements Test {
            @Override /* 文字列を出力 */
            public void execute() {
                System.out.println("hello.");
            }
        }
        return new Hello();
    }

    /* Test インタフェースを実現した Bye ローカルクラスを Test 型で返却 */
    public static Test bye() {

        /** Bye ローカルクラス */
        class Bye implements Test {
            @Override /* 文字列を出力 */
            public void execute() {
                System.out.println("bye.");
            }
        }
        return new Bye();
    }
}

/**
 * <pre>
 * ローカルクラス
 *   - メソッド内に定義するクラス
 *   - 同じクラスであっても、他のメソッドから利用できない
 * </pre>
 */
