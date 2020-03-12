package com.itvillage.chapter09.chapter0902;

import com.itvillage.chapter09.chapter0901.RxJavaTest;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

/**
 * await 을 이용해서 생산자쪽 쓰레드에서 통지가 끝날때까지 또는 지정한 시간만큼 대기하는 예제
 */
public class AwaitTest extends RxJavaTest {
    // 생산자쪽에서 완료 통지를 보낼때까지 대기한 후, 완료 및 통지된 데이터 개수를 검증하는 예제
    @Test
    public void awaitTest() throws InterruptedException {
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .take(5)
                .doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
                .doOnError(error -> Logger.log(LogType.DO_ON_ERROR, error.getMessage()))
                .test()
                .await()
                .assertComplete()
                .assertValueCount(5);
    }

    // 지정한 시간동안 완료 통지를 받지 못해서 Timeout이 되었는지 검증하는 예제
    @Test
    public void awaitTest02() throws InterruptedException {
        boolean result = Observable.interval(1000L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .take(5)
                .doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
                .doOnError(error -> Logger.log(LogType.DO_ON_ERROR, error.getMessage()))
                .test()
                .await(2000L, TimeUnit.MILLISECONDS);

        assertThat(result, is(false));
    }

}
