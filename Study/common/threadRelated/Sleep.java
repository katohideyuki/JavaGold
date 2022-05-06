package threadRelated;


/** 例外処理を記述すると冗長になるため Thread.sleep を切り離す */
public class Sleep {
    public static void exe(long time) throws RuntimeException {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
