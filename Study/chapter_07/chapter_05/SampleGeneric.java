package chapter_05;

/**
 * 汎用とコレクション<br>
 * 制約付きの型パラメータを指定したクラスの使用<br>
 */
public class SampleGeneric {
  public static void main(String[] a) {
    creInstance();
  }

  /**
   * Helloクラスは制約付きの型パラメータを指定したクラスであり、C型は非許容<br>
   */
  private static void creInstance() {
    new Hello<A>().execute(new A());
    new Hello<B>().execute(new B());
//    new Hello<C>().execute(new C());  // 型推論できずコンパイルエラー
  }

}
