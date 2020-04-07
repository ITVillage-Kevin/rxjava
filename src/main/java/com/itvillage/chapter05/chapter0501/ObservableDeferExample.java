package com.itvillage.chapter05.chapter0501;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

import java.time.LocalTime;

/**
 * 실제 구독이 발생할 때 Observable을 새로 반환하여 새로운 Observable을 생성한다.
 * defer()를 활용하면 데이터 흐름의 생성을 지연하는 효과를 보여준다.
 */
public class ObservableDeferExample {
    public static void main(String[] args) throws InterruptedException {
        Observable<LocalTime> observable = Observable.defer(() -> {
            LocalTime currentTime = LocalTime.now();
            return Observable.just(currentTime);
        });

        Observable<LocalTime> observableJust = Observable.just(LocalTime.now());

        observable.subscribe(time -> Logger.log(LogType.PRINT, " # defer() 구독1의 구독 시간: " + time));
        observableJust.subscribe(time -> Logger.log(LogType.PRINT, " # just() 구독1의 구독 시간: " + time));

        Thread.sleep(3000);

        observable.subscribe(time -> Logger.log(LogType.PRINT, " # defer() 구독2의 구독 시간: " + time));
        observableJust.subscribe(time -> Logger.log(LogType.PRINT, " # just() 구독자2의 구독 시간: " + time));
    }
}
