package chapter_04;

import java.util.Locale;

/**
 * ローカライズ<br>
 * ビルダーパターンを使用したLocaleのインスタンス生成<br>
 */
public class SampleLocale {
  public static void main(String[] args) {
    exe();
  }

  /**
   * BuilderはLocaleクラスのインナークラスである<br>
   * - そのため、Builderクラス自身のインスタンス生成が不要<br>
   * - 各setterはBuilder自身の参照を戻すため、メソッドチェインが可能<br>
   */
  private static void exe() {
    var locale = new Locale.Builder()
        .setLanguage("jp")
        .setRegion("JP")
        .setScript("Japa") // setScript()、引数が5文字以上でエラーになる..
        .build();
    System.out.println(locale);
  }
}
