package com.itvillage.chapter05.chapter0502;

import com.itvillage.common.Car;
import com.itvillage.common.CarMaker;
import com.itvillage.common.CarType;
import com.itvillage.quiz.SampleData;
import io.reactivex.Observable;

/**
 * 객체의 특정 필드를 기준으로 distinct 하는 예제
 */
public class ObservableDistinctExample03 {
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .distinct(car -> car.getCarMaker())
                .subscribe(car -> System.out.println(car.getCarName()));

    }
}
