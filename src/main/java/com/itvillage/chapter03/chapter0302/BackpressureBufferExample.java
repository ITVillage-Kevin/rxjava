package com.itvillage.chapter03.chapter0302;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class BackpressureBufferExample {
    public static void main(String[] args){
        // 버퍼에 32개 정도의 데이터만 남게되면 데이터를 다시 발행해서 버퍼에 담는다.
        Flowable.interval(1L, TimeUnit.MILLISECONDS)
                .onBackpressureBuffer(128, () -> Logger.print("Overflow 발생!"), BackpressureOverflowStrategy.DROP_LATEST)
                .doOnNext(data -> Logger.don(data))
                .observeOn(Schedulers.computation())
                .subscribe(
                        data -> {
                            TimeUtil.sleep(5L);
                            Logger.on(data);
                        },
                        error -> Logger.oe(error)
                );

        TimeUtil.sleep(1000L);
    }
}
