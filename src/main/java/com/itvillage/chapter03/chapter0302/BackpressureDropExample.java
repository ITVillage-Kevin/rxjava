package com.itvillage.chapter03.chapter0302;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class BackpressureDropExample {
    public static void main(String[] args){
        Flowable.interval(1L, TimeUnit.MILLISECONDS)
//                .subscribeOn(Schedulers.computation())
                .onBackpressureDrop(dropData -> Logger.print("오버플로우 발생! - " + dropData + " Drop!"))
                .doOnNext(data -> Logger.don(data))
                .observeOn(Schedulers.computation())
                .subscribe(
                        data -> {
                            TimeUtil.sleep(5L);
                            Logger.on(data);
                        },
                        error -> Logger.oe(error)
                );

        TimeUtil.sleep(1500L);
    }
}
