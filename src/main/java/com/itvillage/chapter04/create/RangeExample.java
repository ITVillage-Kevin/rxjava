package com.itvillage.chapter04.create;

import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * 반복문으로 사용 가능
 */
public class RangeExample {
    public static void main(String[] args){
        Observable<Integer> source = Observable.range(0, 5);
        source.subscribe(num -> Logger.on(num));
    }
}
