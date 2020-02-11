package com.itvillage.chapter03.chapter0302;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class BackpressureLatestExample {
    public static void main(String[] args){
        /*
           - 처음 채워진 버퍼의 데이터를 소비자가 모두 소비하면 버퍼를 비우지 않고,
             소비한 데이터를 해당 시점에 발행된 최신 데이터로 교체한다. 즉, 파기(DROP)하는 것이 아니라 overwriting 하는 것.
         */
        Flowable.interval(1L, TimeUnit.MILLISECONDS)
                .onBackpressureLatest()
                .doOnNext(data -> Logger.don(data))
                .observeOn(Schedulers.computation())
                .subscribe(
                        data -> {
                            TimeUtil.sleep(50L);
                            Logger.on(data);
                        },
                        error -> Logger.oe(error)
                );

        TimeUtil.sleep(15500L);
    }
}
