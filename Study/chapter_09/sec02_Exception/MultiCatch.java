package sec02_Exception;

import debug.Debug;
import exceptionRelated.AException;
import exceptionRelated.BException;
import exceptionRelated.CException;
import exceptionRelated.DException;

/** 例外のマルチキャッチ - ポリモーフィズム */
public class MultiCatch {
    public static void main(String[] argas) {
        exceptionUsingPolymo();
    }

    /* ポリモーフィズムにより、例外をスーパークラス型で扱う */
    private static void exceptionUsingPolymo() {
        Debug.log("exceptionUsingPolymo");
        try {
            DException.throwD();  // DException の参照は CException 型としても扱える
            AException.throwA();
            BException.throwB();
            CException.throwC();
        } catch (AException | BException | CException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * <pre>
 * ポリモーフィズムを使った例外のマルチキャッチ
 *   - 継承関係にある例外は、ポリモーフィズムを使えばスーパークラス型の例外として扱える
 *     - 例外をスーパークラス型で扱えば、マルチキャッチの記述を減らせる
 * </pre>
 */
