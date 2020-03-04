package com.itvillage.chapter03.chapter0302;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * 버퍼가 가득차면 버퍼 바깥쪽에서 통지 대기중인 데이터들은 계속 파기(DROP)하고 버퍼를 비운 시점에 통지된 데이터부터 버퍼에 담는다.
 */
public class BackpressureDropExample {
    public static void main(String[] args){
        Flowable.interval(1L, TimeUnit.MILLISECONDS)
                .onBackpressureDrop(dropData -> Logger.log(LogType.PRINT, "오버플로우 발생! - " + dropData + " Drop!"))
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .observeOn(Schedulers.computation())
                .subscribe(
                        data -> {
                            TimeUtil.sleep(5L);
                            Logger.log(LogType.ON_NEXT, data);
                        },
                        error -> Logger.log(LogType.ON_ERROR, error)
                );

        TimeUtil.sleep(1000L);
    }
}
