package sec04_Target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Target アノテーションの使用例
      - nullを許容しないことを示す */
@Target(ElementType.FIELD)            // フィールドに付与されるアノテーション
@Retention(RetentionPolicy.RUNTIME)   // 実行までアノテーションを保有する
public @interface NotNull {
    String message();
}

/**
 * <pre>
 * @Target アノテーション
 *   - そのアノテーションが何を対象としているかを指定するためのメタ・アノテーション
 *   - アノテーションを付与する先を指定しない場合、全てが対象になる
 *
 * lang.annotation.ElementType
 *   - @Target アノテーションの注釈パラメータに渡す列挙型
 *     - ANNOTATION_TYPE : アノテーション宣言
 *     - CONSTRUCTOR     : コンストラクタ宣言
 *     - FIELD           : フィールド宣言
 *     - LOCAL_VARIABLE  : ローカル変数宣言
 *                                ...etc
 * </pre>
 */