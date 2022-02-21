package chapter_04;

import java.util.List;

/**
 * 汎用とコレクション<br>
 * Targetアノテーション<br>
 */
public class Main {
  private static final String NULL = null;
  private static final String EMPTY = "";
  private static final String NAME = "apple";

  public static void main(String[] args) {
    validateExe(NULL);
    validateExe(EMPTY);
    validateExe(NAME);
  }

  /**
   * NotNullValidatorクラスでフィールド値をチェック<br>
   * - 結果、nullかどうかで出力結果を変える<br>
   *
   * @param name
   */
  private static void validateExe(String name) {
    System.out.println("Main.validateExe()");

    System.out.printf("[nameフィールドが%sの場合] : ", name);
    Processor processor = new Processor(name);
    List<String> messageList = NotNullValidator.validate(processor);
    if (messageList.isEmpty()) {
      System.out.println("valid object");
      return;
    }
    messageList.stream().forEach(x -> System.out.println(x));
  }
}
