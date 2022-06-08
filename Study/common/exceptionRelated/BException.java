package exceptionRelated;

/** 独自例外 */
@SuppressWarnings("serial")
public class BException extends Exception {
    /* BException をスローする */
    public static void throwB() throws BException {
        throw new BException();
    }
}
