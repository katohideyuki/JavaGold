package sec08_Immutable;

/** 不変オブジェクトの使用例 */
public class TestBuilder {
    private int num;
    private String str;

    public void setNum(int num) {
        this.num = num;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public ImmutableTest build() {
        // 値がセットされていなければ、デフォルト値をセット
        if (this.str == null)
            this.str = "none";
        return new ImmutableTest(num, str);
    }
}

/**
 * <pre>
 * コンストラクタを使わせず、ビルダーを経由してインスタンスを生成するのは、
 * すべてのフィールドに初期値をセットすることを保証したいから
 * </pre>
 */
