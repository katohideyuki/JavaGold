package sec04_Builder;

/** Locale の使用例 - Builder を使用してインスタンス生成 */
public class Item {
    private final String name;
    private final int price;
    private final int code;

    /** Item クラスの Builder クラス */
    public static class Builder {
        // 必須パラメータ
        private final String name;
        private final int price;

        // オプションパラメータ
        private int code = 0;

        /* Builder コンストラクタ */
        public Builder(String name, int price) {
            this.name  = name;
            this.price = price;
        }

        // 値をセットし、自分自身 Builder を返却
        public Builder code(int code) {
            this.code = code;
            return this;
        }

        // 自分自身を引数に、Item インスタンスを返却
        public Item build() {
            return new Item(this);
        }
    }

    /* Item コンストラクタ */
    public Item(Builder builder) {
        name  = builder.name;
        price = builder.price;
        code  = builder.code;
    }

    @Override /* debug */
    public String toString() {
        return """
            Item
              => name  : %s
                 price : %s
                 code  : %s
            """.formatted(name, price, code);
    }
}

/**
 * <pre>
 * Builder パターン
 *   - 柔軟にインスタンスの生成をするためのデザインパターン
 *     - 次のような場合に使用を検討する
 *       - フィールド数が多い
 *       - すべてのフィールドが必須ではなく、状況に応じて要/不要が変わる
 *     - Builder クラスをネストして利用している理由は、
 *       たとえアクセス修飾子が private なフィールドであっても、
 *       ネストしたクラスからエンクロージングクラスに自由にアクセスできるため
 *   - 将来、フィールドが増えていっても setter メソッドを追加するだけで対応できる
 * </pre>
 */
