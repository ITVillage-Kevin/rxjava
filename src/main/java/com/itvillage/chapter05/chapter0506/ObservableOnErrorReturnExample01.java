package com.itvillage.chapter05.chapter0506;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * 데이터를 처리하다가 예외가 발생할 경우 일반적인 예제
 * 곱셈은 정상적으로 출력되지만 나눗셈에서는 0으로 나누는 부분에서 예외가 발생한다.
 */
public class ObservableOnErrorReturnExample01 {
    public static void main(String[] args) {
        Observable.just(5)
                .flatMap(num -> Observable
                        .interval(200L, TimeUnit.MILLISECONDS)
                        .take(5)
                        .map(i -> num * i))
//                        .map(i -> num / i))
                .subscribe(
                        Logger::on,
                        Logger::oe,
                        Logger::oc
                );

        TimeUtil.sleep(1000L);
    }
}
