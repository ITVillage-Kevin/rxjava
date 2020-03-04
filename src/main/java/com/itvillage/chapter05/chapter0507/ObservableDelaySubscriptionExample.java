package com.itvillage.chapter05.chapter0507;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * 소비자가 구독시, 데이터 생성 및 통지 자체를 지연시키는 예제.
 * 즉, delay()는 소비자가 구독 시, 생성 및 통지는 즉시 하지만 소비자에게 전달하는 시간을 지연시키고,
 * delaySubscription()은 데이터 생성 및 통지 자체를 지연시킨다.
 */
public class ObservableDelaySubscriptionExample {
    public static void main(String[] args) {
        Logger.log(LogType.PRINT, "# 실행 시작 시간: " + TimeUtil.getCurrentTimeFormatted());

        Observable.just(1, 3, 4, 6)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .delaySubscription(2000L, TimeUnit.MILLISECONDS)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(2500L);
    }
}
