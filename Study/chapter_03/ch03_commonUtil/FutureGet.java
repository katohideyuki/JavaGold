package ch03_commonUtil;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/** 例外処理を記述すると冗長になるため Future.get を切り離す */
public class FutureGet {
    public static <T> T exe(Future<T> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
