package com.itvillage.chapter05.chapter0501;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * polling 용도로 주로 사용.
 */
public class ObservableIntervalExample {
    public static void main(String[] args){
        Observable.interval(0L, 1000L, TimeUnit.MILLISECONDS)
                .map(num -> ++num + " count")
                .subscribe(Logger::on);
        TimeUtil.sleep(3000);
    }
}
