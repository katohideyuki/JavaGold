package useRecode;

/** record の使用例 */
public record Book(String title, int price) {

}

/**
 * <pre>
 * record
 *   - 不変データを保持するための特別なクラス
 *   - 「()」内の引数みたいな部分を、ヘッダやら成分(component)と言ったりするらしい
 *   - アクセサや Object 型継承したメソッドを自動で実装する
 *     - 自動生成されるもの
 *       - private final なフィールド
 *       - public な getter
 *       - コンストラクタ
 *       - equals, hashCode
 *         - 同じ型でかつすべての成分が equal であるときのみ等しいとみなされる
 *       - toString
 *         - レコード自体の名前と、全成分の名前および文字列表現を返却
 * </pre>
 */