package com.itvillage.chapter06;

import io.reactivex.subjects.PublishSubject;

/**
 * Observer 가 구독 시점 이 후에 Observable 이 발행한 데이터만 Observer 에게 전달
 */
public class PublishSubjectExample {
    public static void main(String[] args){
        PublishSubject<Integer> subject = PublishSubject.create();

        subject.subscribe(price -> System.out.println("# Observer(Subscriber) 1 : " + price));
        subject.onNext(3500);
        subject.subscribe(price -> System.out.println("# Observer(Subscriber) 2 : " + price));
        subject.onNext(3300);
        subject.subscribe(price -> System.out.println("# Observer(Subscriber) 3 : " + price));
        subject.onNext(3400);
    }
}
