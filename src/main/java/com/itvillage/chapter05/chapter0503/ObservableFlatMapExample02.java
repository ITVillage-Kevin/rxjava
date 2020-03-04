package com.itvillage.chapter05.chapter0503;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * flapMap을 이용한 구구단의 2단 출력 예제
 */
public class ObservableFlatMapExample02 {
    public static void main(String[] args){
        Observable.range(2, 1)
                .flatMap(
                        num -> Observable.range(1, 9)
                                         .map(row -> num + " * " + row + " = " + num * row)
                )
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
