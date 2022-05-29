package sec07_PreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBInformation.DB;
import debug.Debug;

/** PreparedStatement.setXXX の使用例 */
public class UseSetXXX {
    public static void main(String[] args) throws SQLException {
        setParameter();
    }

    /* Insert 文にセットするパラメータをメソッドで設定する */
    private static void setParameter() throws SQLException {
        Debug.log("setParameter");

        var sql              = "insert into item values(?,?)";  // (?,?) => (1番目の?, 2番目の?)
        Connection con       = DB.getCon();
        PreparedStatement ps = con.prepareStatement(sql);
        try (con; ps) {
            ps.setInt(1, 2);            // 1番目の「?」に代入したい値
            ps.setString(2, "sample");  // 2番目に「?」に代入したい値
            System.out.println(ps);
        }
    }
}

/**
 * <pre>
 * preparedStatement.setXXX(何番目, セットしたい値)
 *   - SQL 文にパラメータを渡したい場合、置き換え文字として「?」を使う
 *   - セットしたい列の型によって、setString, setInt といった setXXX という形式
 *     のメソッドを使う
 *   - 第一引数に渡すのは1から始まる番号
 *     - 0を渡した場合、SQLException がスローされる
 * </pre>
 */
