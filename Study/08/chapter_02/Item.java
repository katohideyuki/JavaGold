package chapter_02;

/**
 * アノテーション<br>
 * 独自アノテーションの作り方<br>
 */
@Test(name = "apple", price = 100) // @アノテーション名(フィールド名 = 値) ※Testアノテーションで抽象メソッドを定義していること
@Value("値のみ記述") // Valueアノテーションで抽象メソッドが1つだけなので、記述を省略できる
@SampleAge(age = {1, 2, 3, 4})  // 複数の値の場合、{}内に記述
@DefaultSex // デフォルト値を定義してあるため、値の記述不要
public class Item {
  private String name;
  private int price;
  private String value;
  private int[] age;
  private String sex;

  public Item(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }
}
