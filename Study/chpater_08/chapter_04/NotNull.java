package chapter_04;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 独自アノテーション<br>
 * - nullを許容しないフィールドに対して付与する<br>
 */
@Target(ElementType.FIELD)  // フィールドに付与されるアノテーションということ
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
  String message();
}
