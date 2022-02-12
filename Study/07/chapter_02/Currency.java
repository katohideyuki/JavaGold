package chapter_02;

/**
 * 型パラメータを使ったクラス<br>
 */
public class Currency<T> {
  private T amount;

  // コンストラクタ
  public Currency(T amount) {
    this.amount = amount;
  }

  public T getAmount() {
    return amount;
  }

}
