package com.itvillage.chapter03;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class ObservableCreateCreateExample {
    public static void main(String[] args){
        Observable<String> dataSoucre = Observable.create(
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
        dataSoucre.subscribe(car -> System.out.println(car));


//        Observable.create((ObservableEmitter<String> emitter) -> {
//            emitter.onNext("Canada");
//            emitter.onNext("USA");
//            emitter.onNext("Korea");
//            emitter.onComplete();
//        }).subscribe(car -> System.out.println(car));
    }
}
