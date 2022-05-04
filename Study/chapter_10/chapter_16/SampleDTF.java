package chapter_16;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * ローカライズ<br>
 * DateTimeFormatterクラス/ofPattern/ofLocalizedDateメソッド<br>
 */
public class SampleDTF {
  public static void main(String[] args) {
    getCurrentTime_1st();
    getCurrentTime_2nd();
    getCurrentTime_3rd();
  }

  /**
   * 事前に定義された定数を使ってインスタンス生成<br>
   * 定数はDateTimeFormatter.ISO_DATEなど<br>
   * - formatメソッド<br>
   * --- LocalDate, LocalDateTimeなどのインスタンスの参照を引数に、書式を適用した文字列に変換<br>
   */
  private static void getCurrentTime_1st() {
    DateTimeFormatter isoFormat = DateTimeFormatter.ISO_DATE;
    System.out.println(isoFormat.format(LocalDate.now()));
  }

  /**
   * パターン文字を使ってインスタンス生成<br>
   * - パターン文字 : yyyy-MM-dd など<br>
   */
  private static void getCurrentTime_2nd() {
    var originalFormat = DateTimeFormatter.ofPattern("yyyy年MM月dd年");
    System.out.println(originalFormat.format(LocalDate.now()));
  }

  /**
   *  ローカライズされたスタイルFormatStyleクラスを使ってインスタンス生成<br>
   *  - DateTimeFormatterクラスのstaticメソッド<br>
   *  --- ofLocalizedDateメソッド （日付）<br>
   *  --- ofLocalizedTimeメソッド （時間）<br>
   *  --- ofLocalizedDateTimeメソッド （日付/時間）<br>
   */
  private static void getCurrentTime_3rd() {
    Locale.setDefault(Locale.JAPAN); /* デフォルトのロケール変更 */
    List<FormatStyle> formatList = Arrays.asList( /* FormatStyleのリスト */
        FormatStyle.FULL,
        FormatStyle.LONG,
        FormatStyle.MEDIUM,
        FormatStyle.SHORT);

    formatList.stream()
        .map(format -> DateTimeFormatter.ofLocalizedDate(format))
        .forEach(x -> System.out.println(x.format(LocalDate.now()))); /* インスタンス生成、出力 */
  }
}
