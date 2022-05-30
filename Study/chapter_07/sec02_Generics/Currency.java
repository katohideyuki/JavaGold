package sec02_Generics;

/** ジェネリクスの使用例 - 型パラメータを使ったクラス */
public class Currency<T> {
    private T amount;

    /* コンストラクタ */
    public Currency(T amount) {
        this.amount = amount;
    }

    public T getAmount() { return amount; }

}

/**
 * <pre>
 * 型パラメータ
 *   - 「T」となっている部分が型パラメータ
 *   - 実行時にその型を使うのかを指定することで、そのインスタンスが持つフィールドや
 *     メソッドの型パラメータが置き換わる
 *       - インスタンス生成時に、型を指定することで、好きな型で扱える
 * </pre>
 */