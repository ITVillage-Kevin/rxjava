package com.itvillage.chapter03.chapter0302;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
   - 버퍼에 있는 데이터중 96개 정도의 데이터를 소비자에게 전달하면 전달한 개수만큼 버퍼를 비우고 다시 발행해서 버퍼에 담는다.

   - DROP_OLDEST 전략 : 버퍼가 가득 찬 시점에 가장 나중에 DROP 된 데이터를 기억해두었다가 버퍼를 비우게되면
     기억해둔 데이터부터 버퍼에 담는다.
*/
public class BackpressureBufferExample02 {
    public static void main(String[] args){

        Flowable.interval(200L, TimeUnit.MILLISECONDS)
                .onBackpressureBuffer(
                        1,
                        () -> Logger.log(LogType.PRINT, ""),
                        BackpressureOverflowStrategy.DROP_OLDEST)
//                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .observeOn(Schedulers.computation(), false, 1)
                .subscribe(
                        data -> {
                            TimeUtil.sleep(1000L);
                            Logger.log(LogType.ON_NEXT, data);
                        },
                        error -> Logger.log(LogType.ON_ERROR, error)
                );

        TimeUtil.sleep(4000L);
    }
}
