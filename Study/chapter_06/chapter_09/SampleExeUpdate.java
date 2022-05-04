package chapter_09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DBInformation.DB;

/**
 * JDBC/データベース<br>
 * executeUpdateメソッド<br>
 */
public class SampleExeUpdate {
  public static void main(String[] args) {
    dbInsert();
  }

  /**
   * executeUpdateメソッド<br>
   * - データの挿入、更新、削除を行う<br>
   * --- 検索には使用できない<br>
   * --- 実行した結果の件数をint型で戻す<br>
   */
  private static void dbInsert() {
    try (Connection con = DriverManager.getConnection(DB.URL, DB.USER, DB.PASS)) {
      var sql = "insert into ITEM values(?,?,?)";
      try (var ps = con.prepareStatement(sql)) {

        // valuesに値をセット
        ps.setInt(1, 2);
        ps.setString(2, "banana");
        ps.setInt(3, 200);

        int result = ps.executeUpdate();  // sql実行
        System.out.println(result);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
