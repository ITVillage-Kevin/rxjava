package com.itvillage.chapter05.chapter0503;

import com.itvillage.utils.Logger;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

/**
 * Observable이 배출한 항목에 함수를 적용하여 배출된 값을 변환시킨다.
 */
public class MapExample {
    public static void main(String[] args){
        List<Integer> oddList = Arrays.asList(1, 3, 5, 7);
        Observable.fromIterable(oddList)
                .map(num -> num + 1)
                .subscribe(Logger::on);
    }
}
