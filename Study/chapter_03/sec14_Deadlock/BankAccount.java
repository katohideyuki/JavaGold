package sec14_Deadlock;

import threadRelated.Sleep;

/** デッドロック - 銀行口座を表す */
public class BankAccount {
    private int balance;  // 預金残高

    // コンストラクタ
    public BankAccount(int balance) {
        this.balance = balance;
    }

    /* 入金 - 処理に100ミリ秒かかる */
    public void deposit(int amount) {
        Sleep.exe(100);
        this.balance += amount;
    }

    /* 出金 - 処理に100ミリ秒かかる */
    public void withdrawals(int amount) {
        Sleep.exe(200);
        this.balance -= amount;
    }

    /* 預金残高を取得 */
    public int getBalance() { return balance; }

    @Override /* debug - 出力用 */
    public String toString() { return String.valueOf(getBalance()); }
}
