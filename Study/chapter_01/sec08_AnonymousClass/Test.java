package sec08_AnonymousClass;

/** 匿名クラスの使用例 */
public class Test {

    /** Object クラスのインスタンスではなく、
        Object クラスを継承した匿名のサブクラスのインスタンスを生成している */
    Object obj = new Object() {
        @Override
        public String toString() {
            return "Hello";
        }
    };
}

/**
 * <pre>
 * 匿名クラスはコンストラクタを定義できない
 *   - 名前がないため
 *
 * 匿名クラスは、インタフェース、抽象クラス、具象クラスを継承したサブクラスである
 *   - 重要なのは、new しているクラスそのものをインスタンス化しているわけではない
 * </pre>
 */
