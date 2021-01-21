package com.itvillage.chapter05.chapter0504;

import com.itvillage.common.Car;
import com.itvillage.common.CarMaker;
import com.itvillage.common.SampleData;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observables.GroupedObservable;

/**
 * 제조사 별로 그룹으로 묶은 후, 제조사 별 차량 가격의 합계를 구하는 예제
 */
public class ObservableGroupByExample04 {
    public static void main(String[] args)  {
        Observable<GroupedObservable<CarMaker, Car>> observable =
                Observable.fromIterable(SampleData.carList)
                        .groupBy(car -> car.getCarMaker());

        observable
                .flatMapSingle(carGroup ->
                        Single.just(carGroup.getKey())
                                .zipWith(
                                    carGroup.flatMap(car ->
                                            Observable.just(car.getCarPrice()))
                                                    .reduce((p1, p2)-> p1 + p2)
                                                    .toSingle()
                                    , (key, sum) -> key + ": " + sum
                                )
                )
                .subscribe(System.out::println);
    }
}
