package sec13_PreparedStatement;

import java.sql.SQLException;
import java.util.function.BiConsumer;

/**
 * 呼び出し元のラムダでtry文を書きたくなかったから、Exception対応のBiConsumer型インターフェースを生成<br>
 * - インターフェースを作るハメになり、コードが見やすくなったかどうかは不明<br>
 */
public interface ThrowableBiConsumer<T, U> {
  void accept(T t, U u) throws SQLException;

  /**
   * 処理内容はBiConsumer.acceptメソッドと全く同じ<br>
   * - BiConsumer型のインスタンスを受け取る<br>
   * - 内部で受け取ったBiConsumerインスタンスで、生のacceptメソッドを実行し、その結果を<br>
   * - 例外が起きた場合、acceptTryメソッド内でcatchするため、呼び出し元で例外処理を記述しない<br>
   *
   * @param biCon<PreparedStatement, String> <br>
   * @return
   */
  public static /* 総称型 */ <T, U> BiConsumer<T, U> acceptTry(ThrowableBiConsumer<T, U> biCon) {
    return (t, u) -> {
      try {
        biCon.accept(t, u);
      } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("acceptメソッドで例外をキャッチしました。");
      }
    };
  }
}
/**
 * 総称型のメモ<br>
 * 戻り値の前に<>ジェネリクスを定義する<br>
 * 呼び出す際にジェネリクスを指定することで、任意の型でacceptTryメソッドを実行することができる<br>
 */
