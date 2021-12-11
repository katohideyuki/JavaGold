package chapter_07;

/**
 * 性別、年齢のフィールドを持つPersonクラス<br>
 * - フィールドのgetterを持つ<br>
 *
 */
public class Person {

  public enum Gender {
    MALE, FEMALE
  }

  private int age;
  private Gender gender;

  /**
   * Personクラスのコンストラクタ<br>
   * - 受け取った引数をフィールドにセット<br>
   * @param gender<br>
   * @param age<br>
   */
  public Person(Gender gender, int age) {
    super();
    this.gender = gender;
    this.age = age;
  }
  // ▼ getter
  public Gender getGender() {
    return gender;
  }
  public int getAge() {
    return age;
  }

}
