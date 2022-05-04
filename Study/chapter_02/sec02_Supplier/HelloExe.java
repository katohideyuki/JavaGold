package sec02_Supplier;

import java.util.function.Supplier;

/** Supplier インターフェースの使用例 - hello メソッドを実行 */
public class HelloExe {

  /* B インスタンスの参照を受け取る */
  public void execute(Supplier<A> supplier ) {
    System.out.println("Pre-process");
    A a = supplier.get();
    a.hello();
    System.out.println("Post-process");
  }
}
