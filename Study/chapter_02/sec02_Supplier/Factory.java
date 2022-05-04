package chapter_02;

/** Supplier インターフェースの使用例 - ファクトリークラス */
public class Factory {

  /* Bインスタンスを A型で返す */
  public static A create() {
    return new C();
  }
}

/**
 * <pre>
 * ラムダ式を使用することで、ファクトリークラスは不要となる
 * </pre>
 */