package com.itvillage.chapter05.chapter0502;

import com.itvillage.common.CarMaker;
import com.itvillage.quiz.SampleData;
import io.reactivex.Observable;

public class ObservableDistinctExample02 {
    public static void main(String[] args) {
        Observable.fromArray(SampleData.carMakersDuplicated)
                .distinct()
                .filter(carMaker -> carMaker == CarMaker.SSANGYOUN)
                .subscribe(System.out::println);
    }
}
