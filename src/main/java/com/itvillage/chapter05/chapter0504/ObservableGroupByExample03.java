package com.itvillage.chapter05.chapter0504;

import com.itvillage.common.Car;
import com.itvillage.common.CarMaker;
import com.itvillage.common.SampleData;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observables.GroupedObservable;

/**
 * 제조사를 그룹으로 묶어서 자동차 명을 출력하는 예제
 */
public class ObservableGroupByExample03 {
    public static void main(String[] args) {
        Observable<GroupedObservable<CarMaker, Car>> observable =
                Observable.fromIterable(SampleData.carList)
                        .groupBy(Car::getCarMaker);

        observable
                .flatMapSingle(carGroup ->
                        carGroup.flatMap(car ->
                                Observable.just(car.getCarName()))
                                .toList()
                )
                .subscribe(System.out::println);

    }
}
