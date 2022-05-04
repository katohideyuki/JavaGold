package sec02_Supplier;

/** Supplier インターフェースの使用例 */
public class B implements A {
  @Override
  public void hello() {
    System.out.println("B original process!");
  }
}
