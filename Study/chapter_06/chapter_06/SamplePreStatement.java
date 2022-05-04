package chapter_06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBInformation.DB;

/**
 * JDBC/データベース<br>
 * PreparedStatementインターフェース/Connection.getprepareStatementメソッド<br>
 */
public class SamplePreStatement {
  public static void main(String[] a) {
    sqlStatementCre();
  }

  /**
   * SQL文の準備方法を理解<br>
   * - DBMSがSQL文を理解できるよう事前にコンパイルしておく<br>
   */
  private static void sqlStatementCre() {
    try (Connection con = DriverManager.getConnection(DB.URL, DB.USER, DB.PASS)) {
      var sql = "select * from ITEM;";
      // PreparedStatementもcloseしないと、カーソルがcloseされない（JDBCのリソースを掴みっぱなし）
      try (PreparedStatement pre = con.prepareStatement(sql)) {
        // do something
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
