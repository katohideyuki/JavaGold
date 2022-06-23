package sec08_Immutable;

/** 不変オブジェクトの使用例 */
// final で修飾して継承を禁止
public final class ImmutableTest {

    // フィールドは final で宣言し、変更させない
    private final int num;
    private final String str;

    /* 外部のパッケージからはインスタンス化させない */
    ImmutableTest(int num, String str) {
        this.num = num;
        this.str = str;
    }

    // getterは、参照をそのまま戻さない
    // 新しいインスタンスを生成してその参照を返却
    public String getStr() {
        return new String(str);
    }

    // setter は、元の値を変更せず、新しい値を持った新しいインスタンスを生成して返却
    public ImmutableTest setStr(String str) {
        return new ImmutableTest(this.num, str);
    }
}

/**
 * <pre>
 * 可変性
 *   - インスタンスの状態（フィールドの値の組み合わせ）が変わることがある性質のこと
 *
 * 可変オブジェクト
 *   - フィールドの値が変わることがあるクラス
 *
 * 不変オブジェクト
 *   - フィールドの値が変わらないクラス
 *     - フィールドの値を変更するような setter メソッドは提供しない
 *     - フィールドの値を変更するのであれば、ディープコピーしたインスタンスを生成して
 *       その参照を返却
 *     - フィールドは final で宣言し、コンストラクタで初期値を設定したら変更できない
 *       ようにする
 *     - 継承ができないように、クラス宣言を final で修飾する
 *     - コンストラクタをアクセス修飾子なし、もしくは private で修飾する
 *     - インスタンスを生成するための専用のビルダーを用意する
 *
 * </pre>
 */
