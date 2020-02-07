package com.itvillage.chapter03.chapter0301;

import io.reactivex.subjects.PublishSubject;

public class HotPublisherExample {
    public static void main(String[] args){
        PublishSubject<Integer> subject = PublishSubject.create();
        subject.subscribe(data -> System.out.println("구독자1: " + data));
        subject.onNext(1);
        subject.onNext(3);

        subject.subscribe(data -> System.out.println("구독자2: " + data));
        subject.onNext(5);
        subject.onNext(7);

        subject.onComplete();
    }
}
