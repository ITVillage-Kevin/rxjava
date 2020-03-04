package com.itvillage.chapter05.chapter0502;

import com.itvillage.common.SampleData;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

public class ObservableSkipWhileExample {
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .skipWhile(car -> !car.getCarName().equals("티볼리"))
                .subscribe(car -> Logger.log(LogType.ON_NEXT, car.getCarName()));
    }
}
