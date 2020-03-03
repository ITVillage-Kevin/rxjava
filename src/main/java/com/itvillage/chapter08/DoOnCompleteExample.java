package com.itvillage.chapter08;

import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * onComplete 이벤트 발생 전에 호출되는 doOnComplete 의 사용 예제
 */
public class DoOnCompleteExample {
    public static void main(String[] args) {
        Observable.range(1, 5)
                .doOnComplete(() -> Logger.doc("# 생산자: 데이터 통지 완료"))
                .subscribe(
                        Logger::on,
                        Logger::oe,
                        Logger::oc
                );
    }
}
