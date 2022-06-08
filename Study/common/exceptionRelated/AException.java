package exceptionRelated;

/** 独自例外 */
@SuppressWarnings("serial")
public class AException extends Exception {
    /* AException をスローする */
    public static void throwA() throws AException {
        throw new AException();
    }
}
