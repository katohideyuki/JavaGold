package sec07_Predicate;

/** Predicate インターフェースの使用例
      - 性別、年齢のフィールドを持つクラス */
public class Person {

    /* 性別を定義した enum クラス */
    public enum Gender {
        MALE, FEMALE;
    }

    private final Gender gender;  // 性別
    private final int age;        // 年齢

    /* コンストラクタ */
    public Person(Gender gender, int age) {
        this.gender = gender;
        this.age = age;
    }

    public Gender getGender() { return gender; }
    public int getAge() { return age; }

    /* debug */
    @Override
    public String toString() {
        return String.format(" gender : %s , age : %s %n", getGender(), getAge());
    }
}
