package chapter_07;

/**
 * アノテーション<br>
 * SupressWarningアノテーション/deprecation/removal<br>
 */
public class Suppression {
  public static void main(String[] args) {
    depSuppression();
  }

  /**
   * Deprecated(forRemoval)に対して、deprecationでは抑制できない<br>
   * 抑制するには、removalを指定する必要がある。<br>
   */
  @SuppressWarnings({ /* unusableの警告を抑制 */"deprecation", /* unusanleRemovalの警告を抑制 */"removal" })
  private static void depSuppression() {
    var sd = new SampleDeprecated();
    sd.unusable();
    sd.unusanleRemoval();
  }

}
