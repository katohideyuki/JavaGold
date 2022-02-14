package chapter_09;

import javax.management.remote.SubjectDelegationPermission;

/**
 * 汎用とコレクション<br>
 * 下限境界ワイルドカード<br>
 */
public class minBoundary {
  public static void main(String[] args) {
    boundaryExe();
  }

  /**
   * <? super B>とすることで、Bより上位の型で扱えるようになる<br>
   * - 引数にnull以外の型を指定することが可能<br>
   * - ただし、戻り値はObject型となる<br>
   * --- キャストすることで戻り値もObject型以外にすることができるが、安全ではない（非推奨）<br>
   */
  private static void boundaryExe() {
    Test<? super B> test = new Test<A>(new A());
    Test<? super B> test_2 = new Test<B>(new B());
//    Test<? super B> test_3 = new Test<C>(new C());  // <? super B> Bより上位であること

//    test.setVal(new A());  // AはBのサブクラスではないため、コンパイルエラー
    test.setVal(new B());
    test_2.setVal(new C());

    // 取り出す時は、型の特定ができないためObject型となる
    Object object = test.getVal();
    Object object_2 = test_2.getVal();
    System.out.printf("object : %s, object_2 : %s %n", object, object_2);

    // キャスト式を使えば、任意の型で取り出せるが、安全ではない（非推奨）
    A obA = (A) test.getVal();
    B obB = (B) test_2.getVal();
    System.out.printf("obA : %s, obB : %s %n", obA, obB);
  }
}
