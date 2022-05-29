package sec13_PreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import DBInformation.DB;
import debug.Debug;

/** PreparedStatement.executeBatch の使用例 */
public class UseAddBatch {
    public static void main(String[] args) throws SQLException {
        addMultipleData();
    }

    /* 複数レコードを追加 */
    private static void addMultipleData() throws SQLException {
        Debug.log("addMultipleData");
        String[] names       = {"cherry", "coconut", "cranberry"};  // 商品名
        var sql              = "insert into item values(?,?,?)";    // sql 文
        Connection con       = DB.getCon();
        PreparedStatement ps = con.prepareStatement(sql);
        // ID 10 〜 12でデータを追加する
        try (con; ps) {
            int i = 10; // ID の初期値
            for (String name : names) {
                ps.setInt(1, i);        // ID をセット
                ps.setString(2, name);  // 商品名をセット
                ps.setInt(3, i * 10);   // 値段をセット
                ps.addBatch();          // SQL 文を登録
                i++;
            }
            int[] results = ps.executeBatch();  // SQL 文を実行
            System.out.printf("numbers of add data : %s", Arrays.toString(results));
        }
    }
}

/**
 * <pre>
 * PreparedStatement.addBatch()
 *   - SQL 文を登録
 *
 * PreparedStatement.executeBatch()
 *   - 一度に複数の SQL 文を実行
 *   - 戻り値は、各 SQL 文の更新件数の配列 ※ 更新件数が合算される訳ではない
 * </pre>
 */