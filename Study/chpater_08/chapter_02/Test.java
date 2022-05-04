package chapter_02;

/**
 * Testアノテーション<br>
 * - アノテーションで値を扱いたいため、その値のフィールド名で抽象メソッドを定義<br>
 */
public @interface Test {
  String name();

  int price();

}
