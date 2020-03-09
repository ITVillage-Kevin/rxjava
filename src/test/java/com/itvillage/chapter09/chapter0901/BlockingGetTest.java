package com.itvillage.chapter09.chapter0901;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * blockingGet을 사용한 통지 데이터 테스트 예제
 */
public class BlockingGetTest extends RxJavaTest {
    // A 지점의 월간 매출 합계 테스트
    @Test
    public void totalSalesOfBranchATest(){
        // when
//        int totalSales = sampleObservable.getSalesOfBranchA()
//                .reduce((a, b) -> a + b)
//                .blockingGet();

        // then
        assertThat(Observable.empty().firstElement().blockingGet(), is(326_000_000));
    }

    // A, B, C 지점의 연간 매출 합계 테스트
    @Test
    public void salesAllBranchTest(){
        // when
        int totalSales = Observable.zip(
                sampleObservable.getSalesOfBranchA(),
                sampleObservable.getSalesOfBranchB(),
                sampleObservable.getSalesOfBranchC(),
                (a, b, c) -> a + b + c
        )
        .reduce((a, b) -> a + b)
        .blockingGet();

        // then
        assertThat(totalSales, is(992_000_000));

    }
}
