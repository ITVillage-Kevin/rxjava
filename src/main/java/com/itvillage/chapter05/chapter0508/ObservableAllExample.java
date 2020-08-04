package com.itvillage.chapter05.chapter0508;

import com.itvillage.common.CarMaker;
import com.itvillage.common.SampleData;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * all을 이용하여 통지된 모든 데이터가 파라미터로 입력된 조건과 일치하는지 판단하는 예제
 */
public class ObservableAllExample {
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .doOnNext(car -> Logger.log(LogType.DO_ON_NEXT, "Car Maker: " + car.getCarMaker() +
                        ", \tCar Name: " + car.getCarName()))
                .map(car -> car.getCarMaker())
                .all(carMaker -> carMaker.equals(CarMaker.CHEVROLET))
//                .all(CarMaker.CHEVROLET::equals)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
