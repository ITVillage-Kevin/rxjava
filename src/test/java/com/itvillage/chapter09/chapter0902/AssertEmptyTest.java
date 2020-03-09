package com.itvillage.chapter09.chapter0902;

import com.itvillage.chapter09.chapter0901.RxJavaTest;
import com.itvillage.common.Car;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * assertEmpty를 사용하여 통지된 데이터가 있는지 없는지를 테스트하는 예제
 */
public class AssertEmptyTest extends RxJavaTest {
    @Test
    public void getCarStreamEmptyTest(){
        // when
        Observable<Car> observable = sampleObservable.getCarStream();
        TestObserver<Car> observer = observable.test();

        // then
        observer.awaitDone(100L, TimeUnit.MILLISECONDS).assertEmpty();
    }
}
