package com.itvillage.chapter02;

import io.reactivex.Observable;

public class HelloWorld {
    public static void main(String[] args){
        Observable.just("Hello", "World")
                .subscribe(word -> System.out.println(word));

        Observable.just("Hello", "World")
                .subscribe(System.out::println);
    }
}
