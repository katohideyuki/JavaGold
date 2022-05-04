package chapter_01;

import java.util.Locale;

/**
 * ローカライズ<br>
 * Localeクラス/getDefault/getCountry/getLanguage<br>
 */
public class SampleLocale {
  public static void main(String[] a) {
    exe();
  }

  /**
   * 異なる国や地域で対応できるソフトウェア設計「i18n(Internationalization)」<br>
   */
  private static void exe() {
    var locale = Locale.getDefault(); // 実行しているコンピューターのデフォルトのロケール情報を戻す
    System.out.printf("My Country : %s %n", locale.getCountry());
    System.out.printf("My Language : %s %n", locale.getLanguage());
  }
}
