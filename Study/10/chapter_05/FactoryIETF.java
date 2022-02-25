package chapter_05;

import java.util.Locale;

/**
 * ローカライズ<br>
 * IETF言語タグそのものを組み込んだファクトリメソッド/getLanguageTagメソッド<br>
 */
public class FactoryIETF {
  public static void main(String[] args) {
    exe();
  }

  /**
   * forLanguageTagメソッド<br>
   * - staticなメソッドで、引数で渡されたIETF言語タグに準拠したlocaleインスタンスを生成して、その参照を戻す<br>
   * --- InternetEngineering Task Froce<br>
   */
  private static void exe() {
    Locale locale = Locale.forLanguageTag("en-US-x-lvariant-POSIX");
    System.out.println(locale);
  }

}
