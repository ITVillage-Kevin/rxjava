package com.itvillage.chapter06;

import io.reactivex.subjects.AsyncSubject;

/**
 * Observable 의 데이터 소스 중 마지막 값만 발행
 */
public class AsyncSubjectExample {
    public static void main(String[] args){
        AsyncSubject<Integer> subject = AsyncSubject.create();
        subject.onNext(1000);
        subject.subscribe(price -> System.out.println("# Observer(Subscriber) 1 : " + price));
        subject.onNext(2000);
        subject.subscribe(price -> System.out.println("# Observer(Subscriber) 2 : " + price));
        subject.onNext(3000);

        subject.subscribe(price -> System.out.println("# Observer(Subscriber) 3 : " + price));

        subject.onNext(4000);
        subject.onComplete();
    }
}
