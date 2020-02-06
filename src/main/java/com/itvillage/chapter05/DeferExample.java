package com.itvillage.chapter05;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;

public class DeferExample {
    static Iterator<String> colors = Arrays.asList("1", "3", "5", "6").iterator();

    public static void main(String[] args){
        Callable<Observable<String>> supplier = () -> getObservable();
        Observable<String> source = Observable.defer(supplier);
//        Observable<String> source = getObservable();

        source.subscribe(val -> System.out.println("#1 : " + val));
        source.subscribe(val -> System.out.println("#2 : " + val));
    }

    private static Observable<String> getObservable() {
        if(colors.hasNext()) {
            String color = colors.next();
            return Observable.just(color + "원", color + "네모", color + "오각형");
        }
        return Observable.empty();
    }
}
