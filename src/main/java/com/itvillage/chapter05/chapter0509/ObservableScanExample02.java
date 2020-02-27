package com.itvillage.chapter05.chapter0509;

import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * scan을 이용해 1부터 10까지 sum을 구하는 예제(초기값 있음)
 * - 집계 중간 결과를 계속해서 출력한다.
 */
public class ObservableScanExample02 {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .doOnNext(Logger::don)
                .scan(0, (x, y) -> {
                    Logger.print("# scan 입력 값 : " + x + ", " + y);
                    return x + y;
                })
                .subscribe(Logger::on);
    }
}
