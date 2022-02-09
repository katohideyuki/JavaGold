package chapter_03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DBInformation.DB;

/**
 * JDBC/データベース<br>
 * DriverManagerクラス/getConnectionメソッド<br>
 */
public class SampleDBConnection {

  public static void main(String[] a) {
    conExecution();
  }
  /**
   * データベースに接続<br>
   */
  public static void conExecution() {
    // try-with-resource
    try (Connection con = DriverManager.getConnection(DB.URL, DB.USER, DB.PASS)){
      System.out.println(con);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
