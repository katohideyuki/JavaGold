package chapter_15;

import java.util.Arrays;
import java.util.List;

/**
 * Q.15<br>
 * - 最初の文字列Aを持ったQuestionVauleクラスのみ残り、他は破棄される<br>
 */
public class QuestionTest {
  public static void main(String[] a) {
    List<QuestionVaule> list = Arrays.asList(
        new QuestionVaule("A"),
        new QuestionVaule("B"),
        new QuestionVaule("C"),
        new QuestionVaule("D"));

    Long size = list.stream().distinct().count();
    System.out.println(size);
  }

}
