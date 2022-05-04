package chapter_07;

/**
 * 汎用とコレクション<br>
 * 非境界ワイルドカード「?」が使い勝手の良いモノではなかった<br>
 */
public class NonBoundary {
  public static void main(String[] args) {
    badGood();
  }

  /**
   * 非境界を使う場合<br>
   * - メソッドの戻り値はObject型となる<br>
   * - メソッドの引数はnullしか受け付けない<br>
   * --- 型を特定できないため<br>
   */
  private static void badGood() {
    Test<?> test = new Test<>("hello"); // この時点でTestインスタンスをどの型を扱うか指定しない
    System.out.println((String) test.getValue());// 型を指定していない = Object型となり、String型でダウンキャストすることで型指定する（非推奨）
//    test.setValue("sample"); // valueフィールドの方が不定のため、NG
//    test.setValue(new Object());  // 同上
    test.setValue(null);
    System.out.println(test.getValue());

  }
}
