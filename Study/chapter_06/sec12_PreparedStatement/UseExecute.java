package sec12_PreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import DBInformation.DB;
import debug.Debug;

/** PreparedStatement.execute の使用例 */
public class UseExecute {
    static final String SELECT_SQL = "select * from item";
    static final String UPDATE_SQL = "update item set price = 500 where id = 1";

    public static void main(String[] args) throws SQLException {
        processBranch(UPDATE_SQL);
        processBranch(SELECT_SQL);
    }

    /* execute の結果によって、処理を行う */
    private static void processBranch(String sql) throws SQLException {
        Debug.log("processBranch");
        Connection con       = DB.getCon();
        PreparedStatement ps = con.prepareStatement(sql);
        try (con; ps) {
            // 挿入・更新・削除であれば、実行件数の出力
            if (ps.execute() == false) {
                System.out.printf("numbers of updates : %s%n", ps.getUpdateCount());
                return;
            }
         // 検索結果であれば、id と name を出力 ※ String 型のみ出力
            ResultSet rs           = ps.getResultSet();
            ResultSetMetaData meta = rs.getMetaData();      // メタデータ取得
            int colSize            = meta.getColumnCount(); // レコード数
            while (rs.next()) {
                for (int i = 1; i < colSize; i++)
                    System.out.println(rs.getString(i));
            }
        }
    }
}

/**
 * <pre>
 * PreparedStatement.execute()
 *   - executeUpdate(), executeQuery() の両方の機能を持つメソッド
 *   - 実行結果が、「検索した結果を保持する ResuleSet 型オブジェクト」であれば true を返却
 *     - 使い方として
 *       - 返却値が false であれば、挿入・更新・削除だと判断がつく
 * PreparedStatement.getUpdateCount()
 *   - 更新結果の件数を返却
 *
 * PreparedStatement.getMetaData()
 *   - メタデータを返却
 *
 * ResultSet.getColumnCount()
 *   - カラムが何列あるかを返却
 * </pre>
 */