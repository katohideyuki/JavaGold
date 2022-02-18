package chapter_02;

/**
 * DefaultSexアノテーション<br>
 * - デフォルト値を定義できる<br>
 * --- デフォルト値を使用するクラスは、注釈パラメータの記述自体を省略できる<br>
 */
public @interface DefaultSex {
  String sex() default "Male";

}
