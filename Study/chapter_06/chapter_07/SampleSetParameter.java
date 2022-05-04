package chapter_07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DBInformation.DB;

/**
 * JDBC/データベース<br>
 * setXXXメソッド<br>
 */
public class SampleSetParameter {
  public static void main(String[] a) {
    dbInsert();
  }

  /**
   * setXXXメソッド<br>
   * - (?,?,?)の部分は最終的に(2, "banana", 200)が代入される<br>
   * - 第一引数に「0」は指定できない。<br>
   * --- 指定した場合SQLException発生<br>
   */
  private static void dbInsert() {
    try (Connection con = DriverManager.getConnection(DB.URL, DB.USER, DB.PASS)) {
      var sql = "insert into ITEM value(?,?,?)"; // (/* 1番目 */?, /* 2番目 */?, /* 3番目 */?)
      try (var ps = con.prepareStatement(sql)) {
        ps.setInt(/* 1番目 */1, /* 代入したい値 */2);
        ps.setString(/* 2番目 */2, /* 代入したい値 */"banana");
        ps.setInt(/* 3番目 */3, /* 代入したい値 */200);
        System.out.println(ps);
      }

      // setXXXメソッドでSQLException発生
      try (var ps = con.prepareStatement(sql)) {
        ps.setInt(0, 3); // 第一引数に「0」を代入し、例外発生
        ps.setString(2, "banana");
        ps.setInt(3, 200);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
