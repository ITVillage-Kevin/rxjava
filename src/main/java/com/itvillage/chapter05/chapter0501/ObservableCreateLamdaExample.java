package com.itvillage.chapter05.chapter0501;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

public class ObservableCreateLamdaExample {
    public static void main(String[] args) {
        Observable.create(emitter -> {
            emitter.onNext("Canada");
            emitter.onNext("USA");
            emitter.onNext("Korea");
            emitter.onComplete();
        }).subscribe(System.out::println);
    }
}
