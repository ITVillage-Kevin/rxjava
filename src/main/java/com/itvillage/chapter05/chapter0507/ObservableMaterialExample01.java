package com.itvillage.chapter05.chapter0507;

import com.itvillage.utils.Logger;
import io.reactivex.Observable;

public class ObservableMaterialExample01 {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6)
                .materialize()
                .subscribe(notification -> {
                    String notificationType = notification.isOnNext() ? "onNext()" : (notification.isOnError() ? "onError()" : "onComplete()");
                    Logger.print("notification 타입: " + notificationType);
                    Logger.on(notification.getValue());
                });
    }
}
