package com.itvillage.chapter03.chapter0302;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class BackpressureBufferExample {
    public static void main(String[] args){
        /*
           - 버퍼에 있는 데이터중 96개 정도의 데이터를 소비자에게 전달하면 전달한 개수만큼 버퍼를 비우고 다시 발행해서 버퍼에 담는다.

           - DROP_LATEST 전략 : 버퍼가 가득 찬 시점에 DROP 된 가장 최근의 데이터를 기억해두었다가 버퍼를 비우게되면
             기억해둔 데이터부터 버퍼에 담는다.
        */
        Flowable.interval(1L, TimeUnit.MILLISECONDS)
                .onBackpressureBuffer(
                        128,
                        () -> Logger.print("Overflow 발생!"),
                        BackpressureOverflowStrategy.DROP_LATEST)
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
