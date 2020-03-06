package com.itvillage.chapter09.chapter0901;

import com.itvillage.common.Car;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * blockingFirst를 사용한 통지된 첫번째 데이터를 테스트하는 예제
 */
public class BlockingFirstTest extends RxJavaTest {
    // Car 리스트 중에서 첫번째 Car를 테스트
    @Test
    public void getCarStreamFirstTest(){
        // when
        Car car = sampleObservable.getCarStream().blockingFirst();
        String actual = car.getCarName();

        // then
        assertThat(actual, is("말리부"));
    }

    @Test
    public void getSalesOfBranchAFirstTest(){
        // when
        int actual = sampleObservable.getSalesOfBranchA()
                    .take(6)
                    .blockingFirst();

        // then
        assertThat(actual, is(15_000_000));
    }
}
