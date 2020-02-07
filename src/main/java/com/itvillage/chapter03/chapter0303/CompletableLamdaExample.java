package com.itvillage.chapter03.chapter0303;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.schedulers.Schedulers;

public class CompletableLamdaExample {
    public static void main(String[] args){
        Completable completable = Completable.create(emitter -> {
            // 데이터를 발행하는것이 아니라 특정 작업을 수행한 후, 완료를 통지한다.
            int sum = 0;
            for(int i =0; i < 100; i++){
                sum += i;
            }
            Logger.cp("# 합계: " + sum);

            emitter.onComplete();
        });

        completable.subscribeOn(Schedulers.computation())
                .subscribe(
                        () -> Logger.oc(),
                        error -> Logger.oe(error)
                );

        TimeUtil.sleep(100L);
    }
}
