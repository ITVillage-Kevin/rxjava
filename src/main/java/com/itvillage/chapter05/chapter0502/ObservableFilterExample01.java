package com.itvillage.chapter05.chapter0502;

import com.itvillage.common.CarMaker;
import com.itvillage.common.SampleData;
import io.reactivex.Observable;

public class ObservableFilterExample01 {
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .filter(car -> car.getCarMaker() == CarMaker.CHEVROLET)
                .subscribe(car -> System.out.println(car.getCarName()));
    }
}
