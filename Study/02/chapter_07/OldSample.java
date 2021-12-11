package chapter_07;

import chapter_07.Person.Gender;

/**
 * Personインスタンスが条件に一致するかどうかを判定するクラス<br>
 * - 従来のやり方<br>
 */
public class OldSample {
  public static void main(String[] args) {
    excuteJudge();
  }

  /**
   * 【条件】<br>
   * - gender : 男性/女性<br>
   * - age : 20歳以下<br>
   */
  private static void excuteJudge() {
    Person person = new Person(Gender.MALE, 19); // Personのインスタンス生成（男性、19歳）

    if (person.getGender().equals(Gender.MALE) || person.getGender().equals(Gender.FEMALE) && person.getAge() >= 20) {
      System.out.println("OK");
      return;
    }
    // 条件に当てはまらなかったとき
    System.out.println("NG");
  }
}
