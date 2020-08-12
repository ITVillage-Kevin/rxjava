package com.itvillage.chapter05.chapter0509;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * scan을 이용해 문자열이 누적되어 처리되어 출력되는 예제
 * - 문자열의 처리 중간 결과를 계속해서 출력한다.
 */
public class ObservableScanExample03 {
    public static void main(String[] args) {
        Observable.just("a", "b", "c", "d", "e")
//                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .scan((x, y) -> "(" + x + ", " + y + ")")
                .subscribe(result -> Logger.log(LogType.ON_NEXT, "# 출력 결과: " + result));
    }
}
