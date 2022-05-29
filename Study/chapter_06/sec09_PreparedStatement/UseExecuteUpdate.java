package sec09_PreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBInformation.DB;
import debug.Debug;

/** PreparedStatement の使用例 */
public class UseExecuteUpdate {
    public static void main(String[] args) throws SQLException {
        dbInsert();
    }

    /* データの挿入 */
    private static void dbInsert() throws SQLException {
        Debug.log("dbInsert");
        var sql = "insert into item values(?,?,?)";
        Connection con = DB.getCon();
        PreparedStatement ps = con.prepareStatement(sql);
        try (con; ps) {
            ps.setInt(1, 2);
            ps.setString(2, "banana");
            ps.setInt(3, 200);
            int result = ps.executeUpdate();
            System.out.printf("Numbers od updates : %s", result);
        }
    }
}

/**
 * <pre>
 * PreparedStatement.executeUpdate()
 *   - データの挿入、更新、削除を行う
 * </pre>
 */