package chapter_03;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Testアノテーション<br>
 * - Retentionアノテーションをつけないと、実行時にアノテーションが破棄される<br>
 * --- Testアノテーション情報を取得できない<br>
 */
@Retention(RetentionPolicy.RUNTIME) // 実行時もアノテーション情報を保持する
public @interface Test {
  String name();

  int price();
}
