package sec07_Predicate;

import java.util.function.Predicate;

import debug.Debug;
import sec07_Predicate.Person.Gender;

/** Predicate インターフェースの使用例 */
public class UsePerson {
    private static final Person PERSON_A = new Person(Gender.MALE, 19);
    private static final Person PERSON_B = new Person(Gender.FEMALE, 19);

    public static void main(String[] args) {
        badExample(PERSON_A);
        goodExample(PERSON_B);
    }

    /* 論理演算の組み合わせによる条件判定 - 悪い例 */
    private static void badExample(Person person) {
        Debug.log("badExample");

        // 男性、もしくは女性かつ成人(20歳以上)であるか
        if (person.getGender().equals(Gender.MALE)
                || person.getGender().equals(Gender.FEMALE) && person.getAge() >= 20) {
            System.out.printf(" OK! Over 20  -> %s", person);
            return;
        }
        // 条件に当てはまらなかったとき
        System.out.printf(" Does not meet the condition  -> %s", person);
    }

    /* Predicate のデフォルトメソッドによる条件判定 - 良い例 */
    private static void goodExample(Person person) {
        Debug.log("goodExample");
        Predicate<Person> isMale   = p -> p.getGender().equals(Gender.MALE);    // 男性であればtrue
        Predicate<Person> isFemale = p -> p.getGender().equals(Gender.FEMALE);  // 女性であればtrue
        Predicate<Person> isAdult  = p -> p.getAge() >= 20;                     // 20歳以上であればtrue
        Predicate<Person> criteria = isMale.or(isFemale.and(isAdult));          // 男性、もしくは女性かつ成人(20歳以上)であればtrue ※1

        if (criteria.test(person)) {
            System.out.printf(" OK! Over 20  -> %s", person);
            return;
        }
        // 条件に当てはまらなかったとき
        System.out.printf(" Does not meet the condition  -> %s", person);
    }
}

/**
 * <pre>
 * ※1
 * Predicate.andメソッドや orメソッドは、複数の Predicate オブジェクトを合成し、
 * 新しい Predicate オブジェクトを作るためのメソッド
 *   - Predicate.or()
 *     - || 「または」と同じ意味
 *
 *   - Predicate.and()
 *     - && 「且つ」と同じ意味
 * </pre>
 */
