package chapter_02;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * セキュアコーディング<br>
 * Normalizerクラス/normalizeメソッド<br>
 */
public class SampleNormalizer {
  public static void main(String[] args) {
    canonical();
    compatible();
  }

  /**
   * 正準等価に分解して、「て゛→ で」にする<br>
   * - 見た目、意味同じ<br>
   */
  private static void canonical() {
    System.out.println("SampleNormalizer.Canonical()");
    String de = "\u3066\u3099"; // て + 濁点
    NomalizerConvert.accept(de, Form.NFKC); // で:2文字 → で:1文字
  }

  /**
   * 互換等価性に分解して、「㈱ → (株)」にする<br>
   * - 見た目違う、意味同じ<br>
   */
  private static void compatible() {
    System.out.println("SampleNormalizer.Compatible()");
    String kabu = "\u3231"; // ㈱
    NomalizerConvert.accept(kabu, Form.NFKD); // ㈱ : 1文字 → (株) : 3文字
  }

  /* 文字列と文字数を出力 */
  static Consumer<String> outPrint = str -> System.out.printf("%s : %s文字 %n", str, str.length());

  /**
   * Unicodeの正規化を行う<br>
   * - Unicodeと変換方法を受け取り、出力する
   */
  static BiConsumer<String, Form> NomalizerConvert = (str, form) -> {
    outPrint.accept(str); // 変換前
    String result = Normalizer.normalize(str, form);
    outPrint.accept(result); // 変換後
  };

}
