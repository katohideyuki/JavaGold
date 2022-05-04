package chapter_02;

/** Supplier インターフェースの使用例 */
public class B implements A {
  @Override
  public void hello() {
    System.out.println("B original process!");
  }
}
