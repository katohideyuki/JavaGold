package sec13_PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import DBInformation.DB;

/**
 * JDBC/データベース<br>
 * executeBatchメソッド<br>
 */
public class SampleBatch {
  private static String sql = "update ITEM set price = ? where name = ?;";
  private static int[] results; // SQLの実行結果
  private static Supplier<String> creRandom = () -> String.valueOf(new Random().nextInt(500)); // 乱数を文字列で返す

  // sql文に値をセットするBiConsumer型ラムダ
  // 内部で自作のBiConsumer型acceptTryメソッドを呼び出し、呼び出し先で生のBiConsumer.acceptメソッドを実行
  private static BiConsumer<PreparedStatement, String> setParameter = ThrowableBiConsumer.acceptTry((ps, name) -> {
    ps.setString(1, creRandom.get());
    ps.setString(2, name);
    ps.addBatch();
  });

  public static void main(String[] args) {
    batchExe();
  }

  /**
   * ITEMリストからストリームを生成し、priceカラムにランダムな値をセットし、DBを更新する<br>
   * executeBatchメソッド<br>
   * - 一度に複数のSQL文を実行できる<br>
   * - 戻り値は各SQL文の更新件数の配列であり、すべての更新件数が合算される訳ではない<br>
   */
  private static void batchExe() {
    List<String> itemList = Arrays.asList("apple", "banana", "orange");
    try (Connection con = DriverManager.getConnection(DB.URL, DB.USER, DB.PASS)) {
      try (var ps = con.prepareStatement(sql)) {
        itemList.stream().forEach(name -> {
          setParameter
          .accept(ps, name);
        });
        results = ps.executeBatch();
        System.out.println(Arrays.toString(results));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
