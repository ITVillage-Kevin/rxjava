package com.itvillage.chapter03.chapter0303;

import com.itvillage.utils.DateUtil;
import com.itvillage.utils.Logger;
import io.reactivex.Single;

import java.util.Calendar;

public class SingleLamdaExample {
    public static void main(String[] args){
        Single<String> single = Single.create(emitter -> {
            emitter.onSuccess(DateUtil.getNowDate());
        });

        single.subscribe(
                data -> Logger.osc("# 날짜시각: " + data),
                error -> Logger.oe(error));
    }
}
