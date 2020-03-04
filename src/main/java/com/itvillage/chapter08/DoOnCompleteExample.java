package com.itvillage.chapter08;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * onComplete 이벤트 발생 전에 호출되는 doOnComplete 의 사용 예제
 */
public class DoOnCompleteExample {
    public static void main(String[] args) {
        Observable.range(1, 5)
                .doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE, "# 생산자: 데이터 통지 완료"))
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );
    }
}
