package sec03_BigInteger;

import java.math.BigInteger;

import debug.Debug;

/** BigInteger の使用例 */
public class verifyOverFlow {
    static final BigInteger MAX_NUM = BigInteger.valueOf(Integer.MAX_VALUE);    // int 型の最大値  2147483647
    static final BigInteger MIN_NUM = BigInteger.valueOf(Integer.MIN_VALUE);    // int 型の最小値 -2147483648

    public static void main(String[] args) {
        System.out.println(checkValue(MAX_NUM));
    }

    /* BigInteger に数値を格納する */
    private static BigInteger checkValue(BigInteger val) {
        Debug.log("checkValue");
        if (val.compareTo(MAX_NUM) == 1 || val.compareTo(MAX_NUM) == -1)
            throw new ArithmeticException("Integer overflow");
        return val;
    }
}

/**
 * <pre>
 * 整数オーバーフロー攻撃
 *   - 整数の演算結果が想定外の値を作り出してしまう「整数オーバーフロー」を悪用し、
 *     意図的にこうした処理を行うコードをシステムに侵入させ、実行する攻撃
 *
 * math.BigInteger
 *   - long 型の最大値よりも大きな値を格納することができる
 *   - 値を格納するためのメモリは必要に応じて動的に割り当てられる
 *       - 理論上、BigInteger クラスに格納できる値に上限はない
 * </pre>
 */
