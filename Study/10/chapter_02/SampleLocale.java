package chapter_02;

import java.util.Locale;

/**
 * ローカライズ<br>
 * Localeクラスのインスタンス生成<br>
 */
public class SampleLocale {
  Locale localeLanguage = new Locale("ja"); // 第一引数 : 言語
  Locale localeCountry = new Locale("ja", "JP");  // 第二引数 : 国
  Locale localeCariant = new Locale("ja", "JP", "JP"); // 第三引数 : 派生情報（ベンダーまたはブラウザに固有のコード..?）
}
