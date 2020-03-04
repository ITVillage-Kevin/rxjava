package com.itvillage.chapter03.chapter0302;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class HelloRxJavaFlowableCreateLamdaExample {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable =
                Flowable.create(emitter -> {
                    String[] datas = {"Hello", "RxJava!"};
                    for(String data : datas) {
                        // 구독이 해지되면 처리 중단
                        if (emitter.isCancelled())
                            return;

                        // 데이터 발행
                        emitter.onNext(data);
                    }

                    // 데이터 발행 완료를 알린다
                    emitter.onComplete();
                }, BackpressureStrategy.BUFFER);

        flowable.observeOn(Schedulers.computation())
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                    () -> Logger.log(LogType.ON_COMPLETE),
                    subscription -> subscription.request(Long.MAX_VALUE));

        Thread.sleep(500L);
    }
}
