package sec02_Supplier;

/** Supplier インターフェースの使用例 */
public class UseSupplier {
  public static void main(String[] args) {
    useSupplier();
  }

  /* ラムダ式を引数として渡す */
  private static void useSupplier() {
    HelloExe helloExe = new HelloExe();
    helloExe.execute(B::new);
  }
}

/**
 * <pre>
 * 関数型インターフェースを使用することで、Factory クラスを使わずにインスタンスを生成できる
 * </pre>
 */