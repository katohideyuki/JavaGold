package chapter_11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBInformation.DB;

/**
 * JDBC/データベース<br>
 * executeQueryメソッド/ResultSetクラス/next/getXXXメソッド<br>
 */
public class SampleQuery {
  public static void main(String[] args) {
    query();
  }

  /**
   * executeQueryメソッド<br>
   * - 検索結果のテーブルを戻す<br>
   * --- ResultSet型で受け取り、表とカーソルで表現<br>
   */
  private static void query() {
    try (Connection con = DriverManager.getConnection(DB.URL, DB.USER, DB.PASS)) {
      var sql = "select * from ITEM;";
      try (var ps = con.prepareStatement(sql)) {
        ResultSet rs = ps.executeQuery();
        while (rs.next()) { // 最初、カーソルは表の外を指し、次の行を選択できなければ（データ行がなければ）falseを返す
          System.out.print(rs.getInt(1) + " : "); // 取り出したいカラム番号(左から数え、1から始まる)
          System.out.println(rs.getString("name")); // 取り出したいカラム名
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
