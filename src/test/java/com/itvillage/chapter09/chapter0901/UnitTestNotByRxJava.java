package com.itvillage.chapter09.chapter0901;

import com.itvillage.common.CarMaker;
import io.reactivex.schedulers.Schedulers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

/**
 * RxJava의 API를 사용하지 않은 Unit Test 예제
 */
public class UnitTestNotByRxJava {
    @Test
    public void getCarMakerStreamSyncTest(){
        SampleObservable sampleObservable = new SampleObservable();
        List<CarMaker> carMakerList = new ArrayList<>();
        sampleObservable.getCarMakerStream()
                .subscribe(data -> carMakerList.add(data));
        assertThat(carMakerList.size(), is(5));
    }

    @Test
    public void getCarMakerStreamASyncTest(){
        SampleObservable sampleObservable = new SampleObservable();
        List<CarMaker> carMakerList = new ArrayList<>();
        sampleObservable.getCarMakerStream()
                .subscribeOn(Schedulers.computation())
                .subscribe(data -> carMakerList.add(data));
        assertThat(carMakerList.size(), is(5));
    }
}
