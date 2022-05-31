package sec05_ConstraintParameters;

/** 制約付き型パラメータ */
public class Test<T extends A> {
    public void execute(T t) {
        t.hello();
    }
}

/**
 * <pre>
 * 制約付き型パラメータ
 *   - ジェネリクスを宣言するときに、extend を使って、型パラメータとして使用できるクラスを制限する
 *     例題の場合、A クラスもしくは Aクラスを継承したサブクラスのみ OK となる
 *       - A クラスが hello メソッドを持っているため
 *         - A クラスが hello メソッドを持っていなかった場合、当然コンパイルエラーとなる
 * </pre>
 */