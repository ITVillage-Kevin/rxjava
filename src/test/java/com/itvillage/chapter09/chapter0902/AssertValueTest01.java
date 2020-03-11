package com.itvillage.chapter09.chapter0902;

import com.itvillage.chapter09.chapter0901.RxJavaTest;
import io.reactivex.Observable;
import org.junit.Test;

/**
 * assertValue를 이용한 데이터 검증 예제
 */
public class AssertValueTest01 extends RxJavaTest {
    @Test
    public void assertValueTest(){
        Observable.just("a")
                .test()
                .assertValue("a");
    }
}
