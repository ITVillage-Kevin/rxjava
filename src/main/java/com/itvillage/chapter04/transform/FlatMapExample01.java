package com.itvillage.chapter04.transform;

import com.itvillage.utils.Logger;
import io.reactivex.Observable;

public class FlatMapExample01 {
    public static void main(String[] args){
        Observable.range(1, 2)
                .flatMap(num -> Observable.range(1, 3).map(row -> num + " * " + row + " = " + num * row))
                .subscribe(Logger::on);
    }
}
