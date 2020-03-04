package com.itvillage.chapter05.chapter0506;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * onErrorResumeNext를 이용해서 에러 발생시, 다른 Observable로 대체하는 예제.
 */
public class ObservableOnErrorResumeNextExample {
    public static void main(String[] args) {
        Observable.just(5L)
                .flatMap(num -> Observable
                        .interval(200L, TimeUnit.MILLISECONDS)
                        .take(5)
                        .map(i -> num / i)
                        .onErrorResumeNext(throwable -> {
                            Logger.log(LogType.PRINT, "# 운영자에게 이메일 발송: " + throwable.getMessage());
                            return Observable.interval(200L,TimeUnit.MILLISECONDS).take(5).skip(1).map(i -> num / i);
                        })
                ).subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(2000L);
    }
}
