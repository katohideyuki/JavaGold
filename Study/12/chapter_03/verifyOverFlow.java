package chapter_03;

import java.math.BigInteger;

/**
 * セキュアコーディング<br>
 * 整数オーバーフロー<br>
 */
public class verifyOverFlow {
  private static final BigInteger MAX_INT = BigInteger.valueOf(Integer.MAX_VALUE);
  private static final BigInteger MIN_INT = BigInteger.valueOf(Integer.MIN_VALUE);

  public static void main(String[] args) {
    upCast(10);
    checkInt(MAX_INT);
  }

  /**
   * アップキャストs<br>
   * 入力された値を1つ大きなプリミティブ整数型に型変換して、その型で演算を行う方法d<br>
   *
   * @param 整数
   * @return 引数をそのまま返す<br>
   */
  private static long upCast(long val) throws ArithmeticException {
    if ((val < Integer.MIN_VALUE) || (val > Integer.MAX_VALUE)) {
      throw new ArithmeticException("Integer overflow");
    }
    return val;
  }

  /**
   * プリミティブ型で扱えない大きい数値はBigIntegerを使う<br>
   * 動的にメモリが割り当てられるため、理論上、上限なし<br>
   *
   * @param val
   * @return
   * @throws ArithmeticException
   */
  private static BigInteger checkInt(BigInteger val) throws ArithmeticException {
    if (val.compareTo(MAX_INT) == 1 || val.compareTo(MIN_INT) == -1) {
      throw new ArithmeticException("Integer overfloe");
    }
    return val;
  }

}
