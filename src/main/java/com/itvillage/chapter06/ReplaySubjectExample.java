package com.itvillage.chapter06;

import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectExample {
    public static void main(String[] args){
        ReplaySubject<Integer> subject = ReplaySubject.create();

        subject.subscribe(price -> System.out.println("# Observer(Subscriber) 1 : " + price));
        subject.onNext(3500);

        subject.subscribe(price -> System.out.println("# Observer(Subscriber) 2 : " + price));
        subject.onNext(3300);

        subject.subscribe(price -> System.out.println("# Observer(Subscriber) 3 : " + price));
        subject.onNext(3400);
    }
}
