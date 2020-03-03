package com.itvillage.chapter08;


import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * 데이터 통지 시 마다 실행되는 doOnNext 를 이용해 데이터의 상태를 확인하는 예제
 */
public class DoOnNextExample {
    public static void main(String[] args) {
        Observable.just(1, 3, 5, 7, 9, 10, 11, 12, 13)
                .doOnNext(data -> Logger.don("# 원본 통지 데이터: " + data))
                .filter(data -> data < 10)
                .doOnNext(data -> Logger.don("# filter 적용 후: " + data))
                .map(data -> "#### " + data + " ####")
                .doOnNext(data -> Logger.don("# map 적용 후: " + data))
                .subscribe(data -> Logger.on("# 최종 데이터: " + data));
    }
}
