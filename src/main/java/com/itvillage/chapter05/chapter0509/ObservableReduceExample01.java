package com.itvillage.chapter05.chapter0509;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * reduce를 이용해 1부터 10까지의 sum을 구하는 예제(초기값 없음)
 */
public class ObservableReduceExample01 {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .reduce((x, y) -> x + y)
                .subscribe(result -> Logger.log(LogType.ON_NEXT, "# 1부터 10까지의 누적 합계: " + result));
    }
}
