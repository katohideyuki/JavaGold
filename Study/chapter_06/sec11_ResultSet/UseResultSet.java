package sec11_ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBInformation.DB;
import debug.Debug;

/** ResultSet の使用例 */
public class UseResultSet {
    public static void main(String[] args) throws SQLException {
        dbSearch();
    }

    /*  */
    private static void dbSearch() throws SQLException {
        Debug.log("dbSearch");
        var sql = "select * from item";
        Connection con = DB.getCon();
        PreparedStatement ps = con.prepareStatement(sql);
        try (con; ps) {
            ResultSet rs = ps.executeQuery();
            System.out.println("ID : name : price \n-------------------");
            while (rs.next())
                System.out.printf("%s  : %s, %s%n",
                        rs.getInt(1),           // 取り出したい値をカラム番号で指定(左から数え、一番左のカラムを1とする)
                        rs.getString("name"),   // 取り出したい値をカラム名で指定
                        rs.getString("price")); // 取り出したい値をカラム名で指定
        }
    }
}

/**
 * <pre>
 * PreparedStatement.executeQuery()
 *   - 検索結果のテーブルを返却
 *
 * ResultSet
 *   - 検索結果の表を扱うためのインターフェース
 *   - 表とカーソルで表現でき、最初、カーソルは表の外を指している
 *
 * ResultSet.next()
 *   - カーソルが1行動き、次の行が選択できれば true を返却
 *     - 次に選択できる行がなくなれば、false を返却
 *
 * ResultSet.getXXX()
 *   - 取り出したい型に合わせた getXXX メソッドを持つ
 *     - カラムが String 型であれば getString, int 型であれば getInt
 *     - getXXX の引数は列番号を int 型で渡すか、列名を String 型で渡す
 *       - 列番号は1から始まる
 *     - 行が選択されていない状態で getXXX を実行すると、SQLException をスローする
 * </pre>
 */