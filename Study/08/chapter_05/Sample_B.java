package chapter_05;

/**
 * Overrideアノテーション<br>
 * スーパークラスのシグニチャが一致するかどうかコンパイラが確認<br>
 */
public class Sample_B extends Sample_A {
  @Override
  public void hello() {
    System.out.println("B");
  }

}
