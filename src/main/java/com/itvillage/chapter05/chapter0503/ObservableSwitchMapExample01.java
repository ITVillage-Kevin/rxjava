package com.itvillage.chapter05.chapter0503;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * 원본 소스의 처리 속도가 빨라서 현재 처리 중이던 작업을 중단하는 예제
 */
public class ObservableSwitchMapExample01 {
    public static void main(String[] args) throws InterruptedException {
        TimeUtil.start();
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .take(4)
                .skip(2)
                .switchMap(
                        num -> Observable.interval(150L, TimeUnit.MILLISECONDS)
                                        .take(10)
                                        .skip(1)
                                        .map(row -> num + " * " + row + " = " + num * row)
                )
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        Thread.sleep(3000);
    }
}
