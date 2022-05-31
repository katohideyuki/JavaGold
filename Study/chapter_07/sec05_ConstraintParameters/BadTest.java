package sec05_ConstraintParameters;

/** 制約付き型パラメータ */
public class BadTest<T> {
    public void execute(T t) {
//        t.hello();  // コンパイルエラー
    }
}

/**
 * <pre>
 * hello メソッドを持ったクラスが渡されてくると想定している
 *   - 総称型クラスでは型パラメータ T 型はまだ決まっていないため、
 *     型 T が hello メソッドを持っていることを保証できず、コンパイルエラーとなる
 * </pre>
 */