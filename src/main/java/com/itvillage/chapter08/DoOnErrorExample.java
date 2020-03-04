package com.itvillage.chapter08;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * onError 이벤트 발생 전에 호출되는 doOnError 의 사용 예제
 */
public class DoOnErrorExample {
    public static void main(String[] args) {
        Observable.range(10, 6)
                .zipWith(Observable.just(1, 2, 3, 4, 0, 5), (a, b) -> a / b)
                .doOnError(error -> Logger.log(LogType.DO_ON_EACH, "# 생산자: 에러 발생 - " + error.getMessage()))
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error)
                );
    }
}
