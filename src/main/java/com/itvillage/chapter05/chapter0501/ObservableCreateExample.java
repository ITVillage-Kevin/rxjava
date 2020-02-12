package com.itvillage.chapter05.chapter0501;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class ObservableCreateExample {
    public static void main(String[] args){
        Observable<String> observable = Observable.create(
                new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                        emitter.onNext("Canada");
                        emitter.onNext("USA");
                        emitter.onNext("Korea");
                        emitter.onComplete();
                    }
                }
        );
        observable.subscribe(data -> System.out.println(data));

    }
}
