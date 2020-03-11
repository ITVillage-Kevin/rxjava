package com.itvillage.chapter09.chapter0902;

import com.itvillage.chapter09.chapter0901.RxJavaTest;
import com.itvillage.common.CarMaker;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * assertValues를 이용하여 조건에 맞는 1개 이상의 데이터의 값과 순서과 일치하는지 검증하는 예제
 */
public class AssertValuesTest extends RxJavaTest {
    @Test
    public void getCarMakerAssertValueTest(){
        sampleObservable.getDuplicatedCarMakerStream()
                .filter(carMaker -> carMaker.equals(CarMaker.CHEVROLET))
                .test()
                .awaitDone(1L, TimeUnit.MILLISECONDS)
                .assertValues(CarMaker.CHEVROLET, CarMaker.CHEVROLET);
    }
}
