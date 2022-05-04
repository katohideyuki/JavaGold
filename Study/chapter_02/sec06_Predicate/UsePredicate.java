package sec06_Predicate;

import java.util.function.Predicate;

/* Predicate インターフェースの使用例 */
public class UsePredicate {
  public static void main(String[] args) {
    isLength("");
    isLength("sample");
  }

  /* 受け取った文字列が空かどうか判定 */
  private static void isLength(String str) {
    Predicate<String> p1 = p -> p.isEmpty();
    if (!p1.test(str))
      System.out.println(str);
    else
      System.out.println("String is Empty");
  }
}

/**
 * <pre>
 * Predicate
 *   - 引数を1つ受け取り、判定を行い結果を boolean型で返却する
 *
 * String.isEmpty()
 *   - 空なら true
 * </pre>
 */