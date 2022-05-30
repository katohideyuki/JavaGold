package sec02_Generics;

/** ジェネリクスをの使用例 - 整数だけを扱うクラス */
public class CurrencyInteger {
    private Integer amount;

    /* コンストラクタ */
    public CurrencyInteger(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() { return amount; }

}
