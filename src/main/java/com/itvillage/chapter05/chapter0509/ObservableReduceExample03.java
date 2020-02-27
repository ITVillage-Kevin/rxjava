package com.itvillage.chapter05.chapter0509;

import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * reduce를 이용해 문자열이 누적되어 처리되어 출력되는 예제
 */
public class ObservableReduceExample03 {
    public static void main(String[] args) {
        Observable.just("a", "b", "c", "d", "e")
                .doOnNext(Logger::don)
                .reduce((x, y) -> {
                    Logger.print("# reduce 입력 값 : " + x + ", " + y);
                    return "(" + x + ", " + y + ")";
                })
                .subscribe(Logger::on);
    }
}
