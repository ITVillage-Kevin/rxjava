package com.itvillage.chapter05.chapter0508;

import com.itvillage.common.CarMaker;
import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

public class ObservableAllExample {
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .doOnNext(car -> Logger.don("Car Maker: " + car.getCarMaker() + ", \tCar Name: " + car.getCarName()))
                .map(car -> car.getCarMaker())
                .all(carMaker -> carMaker.equals(CarMaker.CHEVROLET))
//                .all(CarMaker.CHEVROLET::equals)
                .subscribe(Logger::on);
    }
}
