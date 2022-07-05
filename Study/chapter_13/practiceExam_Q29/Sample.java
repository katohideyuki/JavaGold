package practiceExam_Q29;

import debug.Debug;

/** 例外の伝播 */
public class Sample {
    public static void main(String[] args) {
        useThrowTestException();
    }

    /* TestException をスローする */
    private static void throwTestException()  throws TestException {
        Debug.log("TestException");
        try {
            // do something
            throw new TestException("A");
        } catch (SampleException | RuntimeException e) {
            throw new RuntimeException("B");
        }
    }

    /* throwTestException 呼び、catchする */
    private static void useThrowTestException() {
        Debug.log("useThrowTestException");
        try {
            throwTestException();
        } catch (Exception e) {
            System.out.println(e.getMessage());   // B
        }
    }
}

/**
 * <pre>
 * Exception クラスの継承関係
 *   - Throwable
 *       - Error
 *           - エラー係の例外
 *       - Exception
 *           - 非検査例外 (RuntimeException)
 *           - 検査例外
 * </pre>
 */
