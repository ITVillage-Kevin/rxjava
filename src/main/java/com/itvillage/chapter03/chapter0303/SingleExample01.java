package com.itvillage.chapter03.chapter0303;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class SingleExample01 {
    public static void main(String[] args){
        Single<Calendar> single = Single.create(new SingleOnSubscribe<Calendar>() {
            @Override
            public void subscribe(SingleEmitter<Calendar> emitter) throws Exception {
                emitter.onSuccess(Calendar.getInstance());
            }
        });

        single.subscribe(new SingleObserver<Calendar>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                // 아무것도 하지 않음.
            }

            @Override
            public void onSuccess(Calendar calendar) {
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        .format(calendar.getTime()));
            }

            @Override
            public void onError(Throwable error) {
                System.out.println("에러: " + error.getCause());
            }
        });
    }
}
