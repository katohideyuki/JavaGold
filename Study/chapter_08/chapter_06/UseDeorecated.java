package chapter_06;

/** Deprecated アノテーションの使用例 */
public class UseDeorecated {
    @Deprecated
    private String str = "このフィールドは非推奨です";

    @Deprecated
    public void Unusable() {
        System.out.println("このメソッドは非推奨です");
    }

    /* 非推奨のメソッド、フィールドを使用しようとすると、こうなる */
    public void exe() {
        System.out.println(str);
        Unusable();
    }
}

/**
 * <pre>
 * Deprecated アノテーション
 *   - 非推奨のクラス、メソッド、フィールドにマークするアノテーション
 *     - Deprecated アノテーションでマークされたモノを使用していると、コンパイラが警告を発する
 * </pre>
 */
