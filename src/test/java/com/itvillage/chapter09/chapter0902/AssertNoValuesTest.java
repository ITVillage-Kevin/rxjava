package com.itvillage.chapter09.chapter0902;

import com.itvillage.chapter09.chapter0901.RxJavaTest;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * assertNoValues를 이용해 통지 시점까지 통지된 데이터가 없는지 검증하는 예제
 */
public class AssertNoValuesTest extends RxJavaTest {
    @Test
    public void assertNoValuesTest(){
        Observable.interval(200L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
                .filter(data -> data > 5)
                .test()
                .awaitDone(1000L, TimeUnit.MILLISECONDS)
                .assertNoValues();
    }
}
