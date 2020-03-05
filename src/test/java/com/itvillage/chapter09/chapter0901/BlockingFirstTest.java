package com.itvillage.chapter09.chapter0901;

import com.itvillage.common.Car;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * blockingFirst를 사용한 통지된 첫번째 데이터를 테스트하는 예제
 */
public class BlockingFirstTest {
    private static SampleObservable sampleObservable;
    @BeforeClass
    public static void setup(){
        sampleObservable = new SampleObservable();
    }

    @Test
    public void getCarStreamTest(){
        Car actual = sampleObservable.getCarStream().blockingFirst();

        assertThat(actual.getCarName(), is("말리부"));
    }

    @Test
    public void getSalesOfBranchATest(){
        int actual = sampleObservable.getSalesOfBranchA()
                    .take(6)
                    .blockingFirst();

        assertThat(actual, is(15_000_000));
    }
}
