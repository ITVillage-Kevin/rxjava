package com.itvillage.chapter05.chapter0501;

import io.reactivex.Observable;

import java.util.concurrent.CompletableFuture;

public class ObservableCreateFromFutureExample {
    public static void main(String[] args){
        CompletableFuture<Double> future = getMaxPrice();

        Observable.fromFuture(future)
                .subscribe(System.out::print);
    }

    public static CompletableFuture<Double> getMaxPrice(){
        return CompletableFuture.supplyAsync(() -> 350.33);
    }
}
