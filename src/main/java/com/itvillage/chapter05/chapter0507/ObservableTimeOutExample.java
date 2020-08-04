package com.itvillage.chapter05.chapter0507;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * 각 데이터 통지 시, 지정한 시간안에 데이터가 통지 되지 않으면 에러를 발생시키는 예제
 * - 네트워크 연결 지연 등으로 인한 처리를 위해 사용하기 좋은 연산자임.
 */
public class ObservableTimeOutExample {
    public static void main(String[] args) {
        Observable.range(1, 5)
                .map(num -> {
                    long time = 1000L;
                    if(num == 4){
                        time = 1500L;
                    }
                    TimeUtil.sleep(time);
                    return num;
                })
                .timeout(1200L, TimeUnit.MILLISECONDS)
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error)
                );

        TimeUtil.sleep(4000L);
    }
}
