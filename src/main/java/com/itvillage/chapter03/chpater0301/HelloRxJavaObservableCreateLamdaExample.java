package com.itvillage.chapter03.chpater0301;

import com.itvillage.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class HelloRxJavaObservableCreateLamdaExample {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> observable =
                Observable.create(emitter -> {
                    String[] datas = {"Hello", "RxJava!"};
                    for(String data : datas){
                        if(emitter.isDisposed())
                            return;

                        emitter.onNext(data);
                    }
                    emitter.onComplete();
                });

        observable.observeOn(Schedulers.computation())
                .subscribe(
                data -> Logger.on(data),
                error -> Logger.oe(error),
                () -> Logger.oc(),
                disposable -> {/**아무것도 하지 않는다.*/}
        );

         Thread.sleep(500L);
    }
}
