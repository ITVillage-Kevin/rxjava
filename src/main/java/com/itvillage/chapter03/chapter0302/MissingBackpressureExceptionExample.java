package com.itvillage.chapter03.chapter0302;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.security.cert.CertificateRevokedException;
import java.util.concurrent.TimeUnit;

public class MissingBackpressureExceptionExample {
    public static void main(String[] agrs) throws InterruptedException {
        Flowable.interval(1L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.don(data))
                .observeOn(Schedulers.computation())
                .subscribe(
                        data -> {
                            Logger.print("# 소비자 처리 대기 중..");
                            TimeUtil.sleep(1000L);
                            Logger.on(data);
                        },
                        error -> Logger.oe(error),
                        () -> Logger.oc()
                );

        Thread.sleep(2000L);

    }
}
