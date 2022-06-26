package sec09_mutable;

import java.util.Date;

/** 可変オブジェクトの使用例 */
public class TestCalendar {
    private Date date;

    /* コンストラクタ - 引数で受け取ったオブジェクトをそのまま代入しない ※1 */
    public TestCalendar(Date date) {
        this.date = new Date(date.getTime());
    }

    /* コピーコンストラクタ */
    public TestCalendar(TestCalendar input) {
        this.date = new Date(input.date.getTime());
    }

    /* getter - getter メソッドでインスタンスのコピー（クローン）を作って返却 */
    public Date getDate() {
        return (Date)date.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        // 引数を TestCalendar にダウンキャスト
        TestCalendar other = (TestCalendar)obj;
        if (date == null) {
            if (other.date != null) {
                return false;
            }else if (!date.equals(other.date)) {
                return false;
            }
        }
        return true;
    }
}

/**
 * <pre>
 * 可変オブジェクト
 *   - getter メソッドで可変オブジェクトへの参照を返却しないようにする
 *     - getter メソッドで参照を返却するという行為は、フィールドを公開(public)に
 *       しているのと何ら変わらない
 *     - コピーを作って返却するようにする
 *
 * ※1 util.Date クラスも clone メソッドを持っているのだから、使えばよい。とはならず、
 *    このクラスは final なクラスではなく、継承可能なクラスであり、 clone メソッドが
 *    オーバーライド可能なので、意図しない実装で上書きされている可能性がある
 *
 * コピーコンストラクタ
 *   - コピーすることを目的としたコンストラクタ
 *
 * </pre>
 */
