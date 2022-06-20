package sec17_NumberFormat;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * ローカライズ<br>
 * NumberFormatクラス/getInstance/getIntegerInstance/getCurrencyInstance/getPercentInstance<br>
 */
public class SamapleNumberFormat {
  public static void main(String[] a) {
    exe();
  }

  /**
   * NumberFormatのインスタンス生成方法<br>
   * - 抽象クラスなので、newできない<br>
   * - 3桁区切り<br>
   */
  private static void exe() {
    Locale.setDefault(Locale.JAPAN); // ロケール設定(省略可)
    List<NumberFormat> numberFormatList = Arrays.asList(
        NumberFormat.getInstance(),
        NumberFormat.getIntegerInstance(),  // 四捨五入
        NumberFormat.getCurrencyInstance(), // 四捨五入され「¥」がつく
        NumberFormat.getPercentInstance()); //  x100され「%」がつく
    numberFormatList.stream().map(nf -> nf.format(12345.6)).forEach(nf -> System.out.println(nf));
  }
}
