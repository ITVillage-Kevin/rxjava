package com.itvillage.chapter06;

import io.reactivex.subjects.BehaviorSubject;

/**
 * Observer 가 구독하는 시점의 가장 최근에 발행된 값을 Observer 에게 배출
 */
public class BehaviorSubjectExample {
    public static void main(String[] args){
        BehaviorSubject<Integer> subject = BehaviorSubject.createDefault(3000);

        subject.subscribe(price -> System.out.println("# Observer(Subscriber) 1 : " + price));
        subject.onNext(3500);
        subject.subscribe(price -> System.out.println("# Observer(Subscriber) 2 : " + price));
        subject.onNext(3300);
        subject.subscribe(price -> System.out.println("# Observer(Subscriber) 3 : " + price));
        subject.onNext(3400);
    }
}
