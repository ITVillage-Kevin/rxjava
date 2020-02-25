package com.itvillage.chapter05.chapter0507;

import com.itvillage.utils.Logger;
import com.itvillage.utils.NumberUtil;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

/**
 * timeInterval을 이용해 통지되 데이터의 통지 시간을 확인하는 예제
 */
public class ObservableTimeIntervalExample {
    public static void main(String[] args) {
        Observable.just(1, 3, 5, 7, 9)
                .delay(item -> {
                    TimeUtil.sleep(NumberUtil.randomRange(100, 1000));
                    return Observable.just(item);
                })
                .timeInterval()
                .subscribe(
                        timed -> Logger.on("# 통지 시간: " + timed.time() + "\t# 통지된 데이터: " + timed.value())
                );
    }
}
