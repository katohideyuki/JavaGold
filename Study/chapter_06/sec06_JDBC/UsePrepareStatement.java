package sec06_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBInformation.DB;
import debug.Debug;

/** PrepareStatement の使用例 */
public class UsePrepareStatement {
    public static void main(String[] args) throws SQLException {
        prepareSQLStatement();
    }

    /* SQL 文を準備する */
    private static void prepareSQLStatement() throws SQLException {
        Debug.log("prepareSQLStatement");
        var sql              = "select * from item"; // SQL 文
        Connection con       = DB.getCon();
        PreparedStatement ps = con.prepareStatement(sql);
        try (con; ps) {
            System.out.println(con);
            System.out.println(ps);
        }
    }
}

/**
 * <pre>
 * Statement インターフェース
 *   - パラメータなしの SQL 文だけを実行する
 *   - 使う必要なし
 *
 * PreparedStatement
 *   - パラメータを受け取る SQL 文を実行する
 *   - これもクローズしないと、カーソルがオープンのまま、JDBC のリソースを掴みっぱなしになる
 *
 * Connection.prepareStatement(String 型のsql文)
 *   - SQL 文をコンパイルして、PreparedStatement オブジェクトを作成する
 *     ※ DBMS が SQL 文を理解できるよう事前にコンパイルしておく
 * </pre>
 */
