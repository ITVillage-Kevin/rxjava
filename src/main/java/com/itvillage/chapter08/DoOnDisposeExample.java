package com.itvillage.chapter08;

import com.itvillage.common.CarMaker;
import com.itvillage.common.SampleData;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

/**
 * 구독 해지 시 doOnDispose 를 이용하여 지정한 처리를 하는 예제
 */
public class DoOnDisposeExample {
    public static void main(String[] args) {
        Observable.fromArray(SampleData.carMakers)
                .zipWith(Observable.interval(300L, TimeUnit.MILLISECONDS), (carMaker, num) -> carMaker)
                .doOnDispose(() -> Logger.log(LogType.DO_ON_DISPOSE, "# 생산자: 구독 해지 완료"))
                .subscribe(new Observer<CarMaker>() {
                    private Disposable disposable;
                    private long startTime;
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        this.disposable = disposable;
                        this.startTime = TimeUtil.start();
                    }

                    @Override
                    public void onNext(CarMaker carMaker) {
                        Logger.log(LogType.ON_NEXT, carMaker);
                        if(TimeUtil.getCurrentTime() - startTime > 1000L){
                            Logger.log(LogType.PRINT, "# 소비자: 구독 해지 , 1000L 초과");
                            disposable.dispose();
                        }
                    }

                    @Override
                    public void onError(Throwable error) {
                        Logger.log(LogType.ON_ERROR, error);
                    }

                    @Override
                    public void onComplete() {
                        Logger.log(LogType.ON_COMPLETE);
                    }
                });


        TimeUtil.sleep(2000L);
    }
}
