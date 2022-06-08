package exceptionRelated;

/** 独自例外 */
@SuppressWarnings("serial")
public class CException extends Exception {
    /* CException をスローする */
    public static void throwC() throws CException {
        throw new CException();
    }
}
