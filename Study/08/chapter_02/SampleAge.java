package chapter_02;

/**
 * SampleAgeアノテーション<br>
 * - 複数の値をアノテーションで扱いたい場合は配列を使用する<br>
 */
public @interface SampleAge {
  int[] age();
}
