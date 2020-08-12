package com.itvillage.chapter05.chapter0509;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * scan을 이용해 1부터 10까지 sum을 구하는 예제(초기값 있음)
 * - 집계 중간 결과를 계속해서 출력한다.
 */
public class ObservableScanExample02 {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .scan(0, (x, y) -> x + y)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
