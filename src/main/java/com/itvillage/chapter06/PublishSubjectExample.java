package com.itvillage.chapter06;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.subjects.PublishSubject;

/**
 * 소비자가 구독 시점 이 후에 통지 된 데이터만 소비자에게 전달되는 PublishSubject 예제
 */
public class PublishSubjectExample {
    public static void main(String[] args){
        PublishSubject<Integer> subject = PublishSubject.create();

        subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 1 : " + price));
        subject.onNext(3500);
        subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 2 : " + price));
        subject.onNext(3300);
        subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 3 : " + price));
        subject.onNext(3400);

        subject.onComplete();

        subject.subscribe(
                price -> Logger.log(LogType.ON_NEXT, "# 소비자 4 : " + price),
                error -> Logger.log(LogType.ON_ERROR, error),
                () -> Logger.log(LogType.ON_COMPLETE)
        );
    }
}
