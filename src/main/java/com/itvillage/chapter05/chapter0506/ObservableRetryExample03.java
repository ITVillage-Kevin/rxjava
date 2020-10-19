package com.itvillage.chapter05.chapter0506;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * 에러 발생 시, 데이터 통지를 처음부터 다시 하는것을 보여주는 예제
 */
public class ObservableRetryExample03 {
    private final static int RETRY_MAX = 5;
    public static void main(String[] args) {
        Observable.just(10, 12, 15, 16)
                .zipWith(Observable.just(1, 2, 0, 4), (a, b) -> {
                    int result;
                    try{
                        result = a / b;
                    }catch(ArithmeticException ex){
                        Logger.log(LogType.PRINT, "error: " + ex.getMessage());
                        throw ex;
                    }
                    return result;
                })
                .retry(3)
                .onErrorReturn(throwable -> -1)
                .subscribe(
                data -> Logger.log(LogType.ON_NEXT, data),
                error -> Logger.log(LogType.ON_ERROR, error),
                () -> Logger.log(LogType.ON_COMPLETE)
        );

        TimeUtil.sleep(5000L);
    }
}
