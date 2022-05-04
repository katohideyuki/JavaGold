package sec08_BiPredicate;

import java.util.function.BiPredicate;

/* BiPredicate インターフェースの使用例 */
public class UseBiPredicate {
  public static void main(String[] args) {
    excuteBiPredicate();
  }

  /* 第一引数が、第二引数の文字列で終わっていればtrue */
  private static void excuteBiPredicate() {
    BiPredicate<String, String> bi = (str, suffix) -> str.endsWith(suffix);
    System.out.println(bi.test("smaple.class", ".class"));  // true
  }
}

/**
 * BiPredicate
 *   - 引数を２つ受け取る
 *
 * String.endsWith()
 *   - 指定した接尾辞で終るかどうかを判定
 */