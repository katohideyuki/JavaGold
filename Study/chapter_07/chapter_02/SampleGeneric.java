package chapter_02;

/**
 * 汎用とコレクション<br>
 * 総称型/ジェネリクス<br>
 */
public class SampleGeneric {
  public static void main(String[] a) {
    creGeneric();
  }

  /**
   * Integer, Double型のCurrencyインスタンスを生成<br>
   */
  private static void creGeneric() {
    Currency<Integer> currencyInt = new Currency<Integer>(100);
    System.out.printf("amountフィールド:%d を持ったInteger型のCurrencyインスタンスを生成しました%n", currencyInt.getAmount());

    Currency<Double> currencyDouble = new Currency<Double>(1.23);
    System.out.printf("amountフィールド:%.2f を持ったDouble型のCurrencyインスタンスを生成しました%n", currencyDouble.getAmount());
    // %.2f小数点第二位で四捨五入
  }
}
