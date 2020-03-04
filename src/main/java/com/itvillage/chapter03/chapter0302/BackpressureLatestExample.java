package com.itvillage.chapter03.chapter0302;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * 통지된 데이터로 채워진 버퍼의 데이터를 소비자가 모두 소비하면 버퍼 밖에서 대기중인 통지된 데이터 중에서
 * 가장 나중에(최근에) 통지된 데이터부터 다시 버퍼에 채운다.
 */
public class BackpressureLatestExample {
    public static void main(String[] args){
        Flowable.interval(1L, TimeUnit.MILLISECONDS)
                .onBackpressureLatest()
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
