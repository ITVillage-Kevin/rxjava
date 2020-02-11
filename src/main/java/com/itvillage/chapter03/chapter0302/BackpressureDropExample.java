package com.itvillage.chapter03.chapter0302;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class BackpressureDropExample {
    public static void main(String[] args){
        // 버퍼를 비우기 전까지 발행된 데이터는 파기(DROP)하고 버퍼를 비운 시점에 발행된 데이터부터 버퍼에 담는다.
        Flowable.interval(1L, TimeUnit.MILLISECONDS)
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
