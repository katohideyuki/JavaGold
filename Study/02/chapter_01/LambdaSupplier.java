package chapter_01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/** Supplier インターフェースの使用例 */
public class LambdaSupplier {
  public static void main(String[] args) {
    useSupplier();
  }

  private static void useSupplier() {
    Supplier<List<String>> supplier = () -> new ArrayList<String>();
    List<String> list = supplier.get();
    list.add("sample");
    System.out.println(list.get(0));
  }
}

/**
 * <pre>
 * Supplier (提供者)
 *   - 引数を受け取らずに値を返す
 *     - Supplier.get() で呼び出す
 * </pre>
 */