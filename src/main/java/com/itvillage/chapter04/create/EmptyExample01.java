package com.itvillage.chapter04.create;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

public class EmptyExample01 {
    public static void main(String[] args){
        TimeUtil.start();
        Observable.empty()
                .subscribe(
                        empty -> Logger.on(empty),
                        error -> Logger.oe(error),
                        () -> Logger.oc());
    }
}
