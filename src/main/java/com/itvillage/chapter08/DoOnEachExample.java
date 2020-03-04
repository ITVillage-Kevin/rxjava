package com.itvillage.chapter08;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * doOnEach 를 이용해 doOnNext, doOnComplete, doOnError를 한꺼번에 처리하는 예제
 */
public class DoOnEachExample {
    public static void main(String[] args) {
        Observable.range(1, 5)
                .doOnEach(notification -> {
                    if(notification.isOnNext())
                        Logger.log(LogType.DO_ON_NEXT, "# 생산자: 데이터 통지 - " + notification.getValue());
                    else if(notification.isOnError())
                        Logger.log(LogType.DO_ON_EACH, "# 생산자: 에러 발생 - " + notification.getError());
                    else
                        Logger.log(LogType.DO_ON_COMPLETE, "# 생산자: 데이터 통지 완료");
                })
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );
    }
}
