package com.itvillage.chapter05.chapter0504;

import com.itvillage.common.Car;
import com.itvillage.common.CarMaker;
import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

/**
 * Car 제조사 별로 그룹으로 묶어서 데이터를 통지하는 예제
 */
public class ObservableGroupByExample01 {
    public static void main(String[] args) {
        Observable<GroupedObservable<CarMaker, Car>> observable =
                Observable.fromIterable(SampleData.carList).groupBy(Car::getCarMaker);

        observable.subscribe(
                groupedObservable -> groupedObservable.subscribe(
                        car -> Logger.on("Group: " + groupedObservable.getKey() + "\t Car name: " + car.getCarName())
                )
        );

    }
}
