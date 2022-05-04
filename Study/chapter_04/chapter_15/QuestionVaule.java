package chapter_15;

import java.util.Random;

public class QuestionVaule {
  private String data;
  public QuestionVaule(String data) {
    this.data = data;
  }

  /**
   * 常に100を戻す<br>
   */
  @Override
  public int hashCode() {
    return 100;
  }

  /**
   * 常にtrueを戻す<br>
   */
  @Override
  public boolean equals(Object obj) {
    return true;
  }

}
