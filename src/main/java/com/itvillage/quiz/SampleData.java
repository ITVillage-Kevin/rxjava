package com.itvillage.quiz;

import com.itvillage.common.Car;
import com.itvillage.common.CarMaker;
import com.itvillage.common.CarType;

import java.util.Arrays;
import java.util.List;

public class SampleData {
    public static CarMaker[] carMakersDuplicated = {
            CarMaker.CHEVROLET,
            CarMaker.CHEVROLET,
            CarMaker.HYUNDAE,
            CarMaker.SAMSUNG,
            CarMaker.HYUNDAE,
            CarMaker.SSANGYOUNG,
            CarMaker.KIA,
            CarMaker.SSANGYOUNG
    };

    public static List<Car> carList =
            Arrays.asList(
                    new Car(CarMaker.CHEVROLET, "말리부", CarType.SEDAN, 23_000_000),
                    new Car(CarMaker.HYUNDAE, "쏘렌토", CarType.SUV, 33_000_000),
                    new Car(CarMaker.HYUNDAE, "팰리세이드", CarType.SEDAN, 28_000_000),
                    new Car(CarMaker.CHEVROLET, "트래버스", CarType.SUV, 50_000_000),
                    new Car(CarMaker.CHEVROLET, "트랙스", CarType.SUV, 18_000_000),
                    new Car(CarMaker.SSANGYOUNG, "티볼리", CarType.SUV, 23_000_000),
                    new Car(CarMaker.SSANGYOUNG, "G4렉스턴", CarType.SUV, 43_000_000),
                    new Car(CarMaker.SAMSUNG, "SM6", CarType.SUV, 40_000_000),
                    new Car(CarMaker.SAMSUNG, "SM5", CarType.SEDAN, 35_000_000)
            );
}
