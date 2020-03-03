package com.itvillage.chapter08;

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
                        Logger.don("# 생산자: 데이터 통지 - " + notification.getValue());
                    else if(notification.isOnError())
                        Logger.doe("# 생산자: 에러 발생 - " + notification.getError());
                    else
                        Logger.doc("# 생산자: 데이터 통지 완료");
                })
                .subscribe(
                        Logger::on,
                        Logger::oe,
                        Logger::oc
                );
    }
}
