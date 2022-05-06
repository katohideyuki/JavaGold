package sec10_Function;

import java.util.function.Function;

import debug.Debug;

/** Function インターフェースの使用例 */
public class UseFunction {
    private static final Function<Integer, Integer> PLUS  = x -> x + 2;  // 足す
    private static final Function<Integer, Integer> TIMES = x -> x * 2;  // 掛ける

  public static void main(String[] args) {
      useAndThen();
      useCompose();
      useFunctionSynthetic();
  }

  /* Function.andThen */
  private static void useAndThen() {
      Debug.log("useAndThen");
      System.out.println(PLUS.andThen(TIMES).apply(5));
      System.out.println(TIMES.andThen(PLUS).apply(5));
  }
  /* Function.compose */
  private static void useCompose() {
      Debug.log("useCompose");
      System.out.println(PLUS.compose(TIMES).apply(5));
      System.out.println(TIMES.compose(PLUS).apply(5));
  }

  /* 合成した Function の生成と apply メソッドの呼び出しを書き換えたコード */
  private static void useFunctionSynthetic() {
      Debug.log("useFunctionSynthetic");
      // 合成した新しい Function を生成
      Function<Integer, Integer> a = PLUS.andThen(TIMES);
      Function<Integer, Integer> b = TIMES.andThen(PLUS);

      System.out.println(a.apply(5));
      System.out.println(b.apply(5));
  }
}

/**
 * <pre>
 * a.andThen(b)
 *   - a が先に実行され、そのあとに b が実行される
 *
 * a.compose(b)
 *   - b が先に実行され、そのあとに a が実行される
 * </pre>
 */
