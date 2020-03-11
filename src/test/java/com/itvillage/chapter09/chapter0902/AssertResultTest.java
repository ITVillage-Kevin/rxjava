package com.itvillage.chapter09.chapter0902;

import com.itvillage.chapter09.chapter0901.RxJavaTest;
import com.itvillage.common.CarMaker;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * assertResult를 사용하여 통지 완료 후, 통지된 데이터와 파라미터로 입력된 데이터의 값과 순서가 일치하는지 검증하는 예제
 */
public class AssertResultTest extends RxJavaTest {
    // 테스트 실패 예제
    @Test
    public void assertResultFailTest(){
        Observable.interval(200L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
                .filter(data -> data > 3)
                .test()
                .awaitDone(1100L, TimeUnit.MILLISECONDS)
                .assertResult(4L);
    }

    // 테스트 성공 예제
    @Test
    public void assertResultSuccessTest(){
        Observable.interval(200L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
                .take(5)
                .filter(data -> data > 3)
                .test()
                .awaitDone(1100L, TimeUnit.MILLISECONDS)
                .assertResult(4L);
    }
}
