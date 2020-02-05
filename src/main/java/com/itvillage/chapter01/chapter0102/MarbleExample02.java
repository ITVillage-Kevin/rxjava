package com.itvillage.chapter01.chapter0102;

import io.reactivex.Observable;

public class MarbleExample02 {
    public static void main(String[] args){
        Observable<Integer> observable = Observable.just(2, 25, 30, 15, 6);

        observable.subscribe(num -> System.out.println(num));

    }
}
