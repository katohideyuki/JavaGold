package chapter_08;

/**
 * 汎用とコレクション<br>
 * 変数の型パラメータは上限境界ワイルドカードでは解決されない<br>
 */
public class MaxBoundary {
  public static void main(String[] a) {
    BoundaryExe();
  }

  /**
   * 上限境界ワイルドカードでは、変数の型パラメータは特定されない<br>
   * - この時点でどの型で変数を扱うかまだ分からない<br>
   */
  private static void BoundaryExe() {
    Test<? extends B> test = new Test<B>(new B());
    B b = test.getVal();
    b.hello();

    Test<? extends B> test_2 = new Test<C>(new C());
    B c = test_2.getVal();
    c.hello();

//    Test<? extends B> test_3 = new Test<A>(new A());  コンパイルエラー
//    test.setVal(new B());
  }
}
