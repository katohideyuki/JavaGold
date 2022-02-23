package chapter_06;

/**
 * 汎用とコレクション<br>
 * Deprecatedアノテーション<br>
 *
 */
public class SampleDeprecated {
  @Deprecated
  private String str = "このフィールドは非推奨です";

  @Deprecated
  public void Unusable() {
    System.out.println("このメソッドは非推奨です");
  }

  /**
   * Deprecatedアノテーションが付与されたフィールド、メソッドを使用<br>
   * - 警告表示される<br>
   * - クラス全体に付与することも可<br>
   */
  public void exe() {
    System.out.println(str);
    Unusable();
  }

}
