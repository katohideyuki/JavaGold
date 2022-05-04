package chapter_14;

/**
 * 銀行口座を表すクラス
 *
 */
public class BankAccount {
  private int balance; // 預金残高

  // コンストラクタ
  public BankAccount(int balance) {
    this.balance = balance;
  }

  // 入金
  public void deposit(int amount) {
    try {
      Thread.sleep(100);
      this.balance += amount;
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  // 引き出し
  public void withdrawals(int amount) {
    try {
      Thread.sleep(100);
      this.balance -= amount;
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public int getBalance() {
    return balance;
  }
}
