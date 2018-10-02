package com.itvillage.chapter04.create;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.Single;

public class EmptyExample02 {
    public static void main(String[] args) throws InterruptedException {
        TimeUtil.start();
        Single.just(1)
                .doOnSuccess(num -> Logger.don(num))
                .map(num -> {
                    if(num == 1)
                        return "one";
                    else
                        return Observable.empty();

                })
                .subscribe(num -> Logger.os(num));
    }
}
