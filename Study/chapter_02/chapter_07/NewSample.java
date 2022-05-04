package chapter_07;

import java.util.function.Predicate;

import chapter_07.Person.Gender;

/**
 * Personインスタンスが条件に一致するかどうかを判定するクラス<br>
 * - Predicateインターフェースのデフォルトメソッドを使用したやり方<br>
 * -- orメソッド(または)<br>
 * -- andメソッド(且つ)<br>
 * --- 複雑な条件、複数の条件を組み合わせる、時などにPredicateインタフェースが使える<br>
 *
 */
public class NewSample {
  public static void main(String[] args) {
    excuteJudge();
  }

  /**
   * 【条件】<br>
   * - gender : 男性/女性<br>
   * - age : 20歳以下<br>
   */
  private static void excuteJudge() {
    // testメソッド内で呼び出される
    Predicate<Person> preObject_01 = p -> p.getGender().equals(Gender.MALE); // 男性、Predicateオブジェクト1、true
    Predicate<Person> preObject_02 = p -> p.getGender().equals(Gender.FEMALE); // 女性、Predicateオブジェクト2、false
    Predicate<Person> preObject_03 = p -> p.getAge() >= 20; // 20歳以上、Predicateオブジェクト3、false
    Predicate<Person> preResult = preObject_01.or(preObject_02.and(preObject_03)); // true

    Person person = new Person(Gender.MALE, 19); // Personインスタンス生成（男性、19歳）

    // testメソッドを呼びだし、preResultにtrueが入る
    if (preResult.test(person)) {
      System.out.println("OK");
      return;
    }
    System.out.println("NO");
  }
}
