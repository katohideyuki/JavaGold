package sec01_Exception;

import debug.Debug;
import exceptionRelated.AException;
import exceptionRelated.BException;
import exceptionRelated.CException;

/** 例外のマルチキャッチ */
public class MultiCatch {
    public static void main(String[] args) {
        multiCatchExceptions();
    }

    private static void multiCatchExceptions() {
        Debug.log("multiCatchExceptions");
        try {
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
 * 例外のマルチキャッチ
 *   - 例外の種類ごとに記述していた catch ブロックの例外処理を1つにまとめる
 * </pre>
 */
