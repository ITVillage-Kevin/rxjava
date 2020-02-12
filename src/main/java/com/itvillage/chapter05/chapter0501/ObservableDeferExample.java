package com.itvillage.chapter05.chapter0501;

import com.itvillage.utils.Logger;
import io.reactivex.Observable;

public class ObservableDeferExample {
    public static void main(String[] args) throws InterruptedException {
        // 실제 구독이 발생할 때 Observable을 새로 반환하여 새로운 Observable을 생성한다.
        // defer()를 활용하면 데이터의 흐름의 생성을 지연하는 효과를 보여준다.
        Observable<Long> observable = Observable.defer(() -> {
            long time = System.currentTimeMillis();
            return Observable.just(time);
        });

        observable.subscribe(time -> Logger.print(" # 구독자 1의 구독 시간: " + time));

        Thread.sleep(3000);

        observable.subscribe(time -> Logger.print(" # 구독자 1의 구독 시간: " + time));
    }
}
