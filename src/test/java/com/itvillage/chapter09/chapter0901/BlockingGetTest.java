package com.itvillage.chapter09.chapter0901;

import io.reactivex.Observable;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BlockingGetTest extends RxJavaTest {
    // A 지점의 월간 매출 합계 테스트
    @Test
    public void totalSalesOfBranchATest(){
        // when
        int totalSales = sampleObservable.getSalesOfBranchA()
                .reduce((a, b) -> a + b)
                .blockingGet();

        // then
        assertThat(totalSales, is(326_000_000));
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
