package sec03_Reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/** リフレクション */
@Retention(RetentionPolicy.RUNTIME)   // 実行時もアノテーション情報を保持する
public @interface Test {
    String name();
    int price();
}

/**
 * <pre>
 * Retention
 *   - アノテーションの保有期間を定義する
 *   - アノテーションを定義するためのアノテーションを「メタ・アノテーション」と呼ぶ
 *
 *  RetentionPolicy
 *    - アノテーションの保有期間を表す列挙型
 *      - RetentionPolicy.CLASS   : 実行時に破棄
 *      - RetentionPolicy.RUNTIME : 実行時まで保持する （ほぼこれ）
 *      - RetentionPolicy.SOURCE  : コンパイル時に破棄
 * </pre>
 */
