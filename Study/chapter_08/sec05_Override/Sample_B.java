package sec05_Override;

/** Override アノテーション の使用例 */
public class Sample_B extends Sample_A {
    @Override
    public void hello() {
        System.out.println("B");
    }
}

/**
 * <pre>
 * Override アノテーション
 *   - あるクラスを継承したサブクラスで、スーパークラスのメソッドを再定義すること
 *   - スーパークラスの変更を検知するために使えるアノテーション
 *   - スーパークラスのオーバーライドされた側のメソッドとシグニチャが一致するかどうかコンパイラが確認
 * </pre>
 */
