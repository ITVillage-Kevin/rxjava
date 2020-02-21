package com.itvillage.chapter05.chapter0507;

import com.itvillage.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Arrays;

/**
 * Material/Dematerial 연산자의 실제 활용 예제
 * - 특정 Observable 에서 에러가 발생 할 경우 해당 에러에 대해서 구체적으로 처리할 수 있다.
 */
public class ObservableMaterialExample02 {
    public static void main(String[] args) {
        Observable.concatEager(
                Observable.just(
                        getDBUser(),
                        getAPIUser()
                                .subscribeOn(Schedulers.io())
                                .materialize()
                                .map(notification -> {
                                    if (notification.isOnError()) {
                                        // 관리자에게 에러 발생을 알림
                                        Logger.print("# API user 에러 발생!");
                                    }
                                    return notification;
                                })
                                .filter(notification -> !notification.isOnError())
                                .dematerialize(notification -> notification)
                )
        ).subscribe(
                Logger::on,
                Logger::oe,
                Logger::oc
        );
    }

    private static Observable<String> getDBUser() {
        return Observable.fromIterable(Arrays.asList("DB user1", "DB user2", "DB user3", "DB user4", "DB user5"));
    }

    private static Observable<String> getAPIUser() {
        return Observable
                .just("API user1", "API user2", "Not User", "API user4", "API user5")
                .map(user -> {
                    if(user.equals("Not User"))
                        throw new RuntimeException();
                    return user;
                });
    }
}
