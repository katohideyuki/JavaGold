package chapter_12;

import java.util.ResourceBundle;

/**
 * ローカライズ<br>
 * ResourceBundleクラス/getBundle/getStringメソッド<br>
 */
public class RB {
  public static void main(String[] args) {
    System.out.println(System.getProperty("java.class.path"));
    exe();
  }

  /**
   * ResourceBundleクラス<br>
   * - Locale, デフォルトでUTF-8を扱える<br>
   * - 抽象クラスなので、newでインスタンス生成はできない<br>
   * --- getBundleメソッドでインスタンス生成する<br>
   *
   * 実行すると「java.util.MissingResourceException」発生<br>
   * - 環境を見直すも、すぐ解消されなかったため一旦スルー<br>
   */
  private static void exe() {
    var br = ResourceBundle.getBundle("Japanese");  // 拡張子は不要(基底名のみ)
    System.out.println(br.getString("test2"));
  }
}
