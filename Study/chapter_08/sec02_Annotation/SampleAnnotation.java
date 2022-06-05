package sec02_Annotation;

/** アノテーション
      - 独自アノテーション */
public @interface SampleAnnotation {

    /** 値を扱う抽象メソッドを定義 */
    public @interface Value {
        String value();
    }

    /** 複数の値を扱う抽象メソッドを定義  */
    public @interface ArrayValues {
        int[] data();
    }

    /** アノテーション - デフォルトの値を扱う抽象メソッドを定義 */
    public @interface DefaultValue {
        String test() default "default";
    }
}

/**
 * <pre>
 * アノテーションを独自で定義する場合
 *   - @interface をつける
 *     - コンパイルされるとインタフェースに置き換わる
 *       public intaeface Test extends Annotation みたいに
 *
 * アノテーションで値を扱いたい場合
 *   - その値を返却する抽象メソッドをアノテーションに追加する
 *   - アノテーションで扱う値のことを「注釈パラメータ」と呼ぶ
 *     - 複数の値を扱う場合は、配列を利用する
 *     - デフォルト値を設定できる
 *       - default に続けてデフォルト値を定義
 * </pre>
 */
