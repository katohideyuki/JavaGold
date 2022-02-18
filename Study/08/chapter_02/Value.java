package chapter_02;

/**
 * Valueアノテーション<br>
 * - 抽象メソッドを1つのみ定義<br>
 * --- 1つのみの場合、使用するクラスで記述する注釈パラメータを一部省略できる<br>
 */
public @interface Value {
  String value();
}
