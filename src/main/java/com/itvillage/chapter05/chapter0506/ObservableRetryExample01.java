package com.itvillage.chapter05.chapter0506;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableRetryExample01 {
    public static void main(String[] args) {
        Observable.just(5)
                .flatMap(
                        num -> Observable
                                .interval(200L, TimeUnit.MILLISECONDS)
                                .map(i -> {
                                    long result;
                                    try{
                                        result = num / i;
                                    }catch(ArithmeticException ex){
                                        Logger.print("error: " + ex.getMessage());
                                        throw ex;
                                    }
                                    return result;
                                })
                                .retry(5)
                                .onErrorReturn(throwable -> -1L)
                ).subscribe(
                        Logger::on,
                        Logger::oe,
                        Logger::oc
                );

        TimeUtil.sleep(5000L);
    }
}
