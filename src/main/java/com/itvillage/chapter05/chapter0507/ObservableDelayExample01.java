package com.itvillage.chapter05.chapter0507;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * 통지된 데이터를 소비자 쪽에서 전달 받는 시간을 일정 시간동안 지연 시키는 예제
 */
public class ObservableDelayExample01 {
    public static void main(String[] args) {
        Logger.print("# 실행 시작 시간: " + TimeUtil.getCurrentTimeFormatted());

        Observable.just(1, 3, 4, 6)
                .doOnNext(Logger::don)
                .delay(2000L, TimeUnit.MILLISECONDS)
                .subscribe(Logger::on);

        TimeUtil.sleep(2500L);
    }
}
