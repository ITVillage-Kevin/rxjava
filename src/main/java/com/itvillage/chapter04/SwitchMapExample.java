package com.itvillage.chapter04;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class SwitchMapExample {
    public static void main(String[] args) throws InterruptedException {
        TimeUtil.start();
        Observable.just(1,2)
                .doOnNext(Logger::don)
                .switchMap(num1 -> Observable.just(num1).delay(100, TimeUnit.MILLISECONDS))
                .subscribe(Logger::on);

        Thread.sleep(1000);
    }
}
