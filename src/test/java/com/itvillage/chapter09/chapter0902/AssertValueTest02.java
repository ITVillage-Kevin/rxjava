package com.itvillage.chapter09.chapter0902;

import com.itvillage.chapter09.chapter0901.RxJavaTest;
import com.itvillage.common.CarMaker;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * assertValue를 이용하여 조건에 해당되는 하나의 자동차 메이커를 검증하는 예제
 */
public class AssertValueTest02 extends RxJavaTest {
    @Test
    public void getCarMakerAssertValueTest(){
        sampleObservable.getCarMakerStream()
                .filter(carMaker -> carMaker.equals(CarMaker.SAMSUNG))
                .test()
                .awaitDone(1L, TimeUnit.MILLISECONDS)
                .assertValue(CarMaker.SAMSUNG);
    }
}
