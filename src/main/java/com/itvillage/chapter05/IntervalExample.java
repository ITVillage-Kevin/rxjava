package com.itvillage.chapter05;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * polling 용도로 주로 사용.
 */
public class IntervalExample {
    public static void main(String[] args){
        TimeUtil.start();
        Observable.interval(0L, 100L, TimeUnit.MILLISECONDS)
                .map(num -> ++num + " count")
                .subscribe(Logger::on);
        TimeUtil.sleep(1000);
    }
}
