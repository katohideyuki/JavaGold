package chapter_12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.function.Predicate;

import javax.security.auth.x500.X500Principal;

import java.sql.ResultSetMetaData;

import DBInformation.DB;

/**
 * JDBC/データベース<br>
 * PreparedStatement.executeメソッド<br>
 */
public class SampleExecute {
  private static String random = String.valueOf(new Random().nextInt(500)); // 乱数生成し文字列に変換
  private static String sqlUpdate = "update ITEM set price = " + random + " where name = 'apple';"; // SQL文（乱数により値段が決まる）
  private static String sqlQuery = "select * from ITEM;"; // SQL文

  public static void main(String[] args) {
    dbExecute(sqlUpdate);
    dbExecute(sqlQuery);
  }

  /**
   * PreparedStatement.executeメソッド<br>
   * - 実行結果が「検索した結果を保持するResult型オブジェクト」かどうかをBoolean型で戻す<br>
   * --- 検索で使用した場合、ResultSetオブジェクトが返るため分岐として使用<br>
   * @param sql
   */
  private static void dbExecute(String sql) {
    try (Connection con = DriverManager.getConnection(DB.URL, DB.USER, DB.PASS)) {

      try (var ps = con.prepareStatement(sql)) {

        // sqlの結果が「挿入、更新、削除」の場合
        if (ps.execute() == false) {
          System.out.println("---------------------▼ sqlUpdate ---------------------");
          System.out.println(ps.getUpdateCount());
          return;
        }

        // sqlの結果が「検索」の場合
        System.out.println("---------------------▼ sqlQuery ---------------------");
        ResultSet rs = ps.getResultSet();
        ResultSetMetaData meta = rs.getMetaData(); // メタデータ取得
        int colSize = meta.getColumnCount(); // カラム数を取得
        while (rs.next()) {
          for (int i = 1; i <= colSize; i++) {
            System.out.println(rs.getString(i));
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
