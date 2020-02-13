package com.itvillage.quiz;

import com.itvillage.common.Car;
import com.itvillage.common.CarMaker;
import com.itvillage.common.CarType;

import java.util.Arrays;
import java.util.List;

public class QuizData {
    public static List<Car> CarData =
            Arrays.asList(
                new Car(CarMaker.CHEVROLET, "말리부", CarType.SEDAN, 23000000),
                new Car(CarMaker.HYUNDAE, "쏘렌토", CarType.SUV, 33000000),
                new Car(CarMaker.HYUNDAE, "팰리세이드", CarType.SEDAN, 28000000),
                new Car(CarMaker.CHEVROLET, "트래버스", CarType.SUV, 50000000),
                new Car(CarMaker.CHEVROLET, "트랙스", CarType.SUV, 18000000),
                new Car(CarMaker.SSANGYOUN, "티볼리", CarType.SUV, 23000000),
                new Car(CarMaker.SSANGYOUN, "G4렉스턴", CarType.SUV, 43000000)
            );
}
