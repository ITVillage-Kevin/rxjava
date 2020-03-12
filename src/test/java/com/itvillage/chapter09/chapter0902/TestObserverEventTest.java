package com.itvillage.chapter09.chapter0902;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestObserverEventTest {
    // 완료 통지 이벤트가 발생했는지를 검증하는 예제
    @Test
    public void isTerminalEventTest(){
        boolean result = Observable.interval(200L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .take(5)
                .doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
                .doOnError(error -> Logger.log(LogType.DO_ON_ERROR, error.getMessage()))
                .test()
                .awaitCount(5)
                .isTerminated();

        assertThat(result, is(true));
    }

    // 에러 통지 이벤트가 발생했는지를 검증하는 예제
    @Test
    public void isErrorEventTest(){
        boolean result = Observable.interval(200L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .take(5)
                .map(data -> {
                    if(data == 2)
                        throw new RuntimeException("Error happened");
                    return data;
                })
                .doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
                .doOnError(error -> Logger.log(LogType.DO_ON_ERROR, error.getMessage()))
                .test()
                .awaitCount(5)
                .isTerminated();

        assertThat(result, is(true));
    }
}
