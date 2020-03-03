package com.itvillage.chapter08;

import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * onError 이벤트 발생 전에 호출되는 doOnError 의 사용 예제
 */
public class DoOnErrorExample {
    public static void main(String[] args) {
        Observable.range(10, 6)
                .zipWith(Observable.just(1, 2, 3, 4, 0, 5), (a, b) -> a / b)
                .doOnError(error -> Logger.doe("# 생산자: 에러 발생 - " + error.getMessage()))
                .subscribe(
                        Logger::on,
                        error -> Logger.oe(error)
                );
    }
}
