package com.itvillage.chapter03;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class ObservableCreateFromIterableExample {
    public static void main(String[] args){
        List<String> countries = Arrays.asList("Korea", "Canada", "USA", "Italy");

        Observable.fromIterable(countries)
                .subscribe(System.out::println);
    }
}
