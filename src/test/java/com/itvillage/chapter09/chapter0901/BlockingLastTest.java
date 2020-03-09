package com.itvillage.chapter09.chapter0901;

import com.itvillage.common.Car;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * blockingLast를 사용한 통지된 마지막 데이터를 테스트하는 예제
 */
public class BlockingLastTest extends RxJavaTest {
    // Car 리스트 중 마지막 Car 테스트
    @Test
    public void getCarStreamLastTest(){
        // when
        Car car = sampleObservable.getCarStream().blockingLast();
        String actual = car.getCarName();

        // then
        assertThat(actual, is("SM5"));
    }

    // A 지점의 월간 매출액 중 6월 달 매출액 테스트
    @Test
    public void getSalesOfBranchALastTest(){
        // when
        int actual = sampleObservable.getSalesOfBranchA()
                    .take(6)
                    .blockingLast();

        // then
        assertThat(actual, is(40_000_000));
    }
}
