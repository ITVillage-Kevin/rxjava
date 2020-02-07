package com.itvillage.chapter03.chapter0303;

import com.itvillage.utils.DateUtil;
import com.itvillage.utils.Logger;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class SingleCreateExample {
    public static void main(String[] args){
        Single<String> single = Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(SingleEmitter<String> emitter) throws Exception {
                emitter.onSuccess(DateUtil.getNowDate());
            }
        });

        single.subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                // 아무것도 하지 않음.
            }

            @Override
            public void onSuccess(String data) {
                Logger.osc("# 날짜시각: " + data);
            }

            @Override
            public void onError(Throwable error) {
                Logger.oe(error);
            }
        });
    }
}
