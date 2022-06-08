package exceptionRelated;

/** 独自例外 - CException を継承 */
@SuppressWarnings("serial")
public class DException extends CException {
    /* DException をスローする */
    public static void throwD() throws DException {
        throw new DException();
    }
}
