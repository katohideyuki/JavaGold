package sec03_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DBInformation.DB;
import debug.Debug;

/** DriverManager の使用例 */
public class DBConnection {
    public static void main(String[] args) throws SQLException {
        connectionWithDBMS();
    }

    /* DBMSとの接続 */
    private static void connectionWithDBMS() throws SQLException {
        Debug.log("connectionWithDBMS");
        Connection con = DriverManager.getConnection(DB.URL, DB.USER, DB.PASS);
        try (con) {
           System.out.println(con);
        }
    }
}

/**
 * <pre>
 * sql.Connection インターフェース
 *   - DBMS との接続を管理するため
 *
 * DriverManager.getConnection(String 型の DBMS への情報)
 *   - DBMS へ接続する
 * </pre>
 */