package chapter_02;

/** Supplier インターフェースの使用例 */
public class C implements A {
  @Override
  public void hello() {
    System.out.println("C original process!");
  }
}
