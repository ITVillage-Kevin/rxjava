package com.itvillage.chapter05.chapter0502;

import com.itvillage.common.Car;
import com.itvillage.common.CarMaker;
import com.itvillage.common.CarType;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class ObservableFilterExample02 {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car(CarMaker.CHEVROLET, "말리부", CarType.SEDAN, 23000000),
                new Car(CarMaker.HYUNDAE, "쏘렌토", CarType.SUV, 33000000),
                new Car(CarMaker.HYUNDAE, "팰리세이드", CarType.SEDAN, 28000000),
                new Car(CarMaker.CHEVROLET, "트래버스", CarType.SUV, 50000000),
                new Car(CarMaker.CHEVROLET, "트랙스", CarType.SUV, 18000000),
                new Car(CarMaker.SSANGYOUN, "티볼리", CarType.SUV, 23000000),
                new Car(CarMaker.SSANGYOUN, "G4렉스턴", CarType.SUV, 43000000)
        );

        Observable.fromIterable(cars)
                .filter(car -> car.getCarMaker() == CarMaker.CHEVROLET)
                .filter(car -> car.getCarPrice() > 30000000)
                .subscribe(car -> System.out.println(car.getCarName()));
    }
}
