package com.itvillage.chapter09.chapter0902;

import com.itvillage.chapter09.chapter0901.RxJavaTest;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * assertXXX 함수를 체인으로 연결하여 다양한 케이스의 검증을 할 수 있는 예제
 */
public class AssertChainTest extends RxJavaTest {
    @Test
    public void assertChainTest() {
        Observable.interval(200L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
                .test()
                .awaitDone(1100L, TimeUnit.MILLISECONDS)
                .assertNotComplete()
                .assertNoErrors()
                .assertValueCount(5);
    }

}
