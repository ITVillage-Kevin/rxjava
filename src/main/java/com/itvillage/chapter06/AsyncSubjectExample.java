package com.itvillage.chapter06;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.subjects.AsyncSubject;

/**
 * 구독 시점에 상관없이 모든 소비자들이 마지막으로 통지된 데이터만 전달 받는 AsyncSubject 예제
 */
public class AsyncSubjectExample {
    public static void main(String[] args){
        AsyncSubject<Integer> subject = AsyncSubject.create();
        subject.onNext(1000);

        subject.doOnNext(price -> Logger.log(LogType.DO_ON_NEXT, "# 소비자 1 : " + price))
                .subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 1 : " + price));
        subject.onNext(2000);

        subject.doOnNext(price -> Logger.log(LogType.DO_ON_NEXT, "# 소비자 2 : " + price))
                .subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 2 : " + price));
        subject.onNext(3000);

        subject.doOnNext(price -> Logger.log(LogType.DO_ON_NEXT, "# 소비자 3 : " + price))
                .subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 3 : " + price));
        subject.onNext(4000);

        subject.onComplete();
    }
}
