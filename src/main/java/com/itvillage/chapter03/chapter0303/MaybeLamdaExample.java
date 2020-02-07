package com.itvillage.chapter03.chapter0303;

import com.itvillage.utils.DateUtil;
import com.itvillage.utils.Logger;
import io.reactivex.Maybe;

public class MaybeLamdaExample {
    public static void main(String[] args){
        Maybe<String> maybe = Maybe.create(emitter -> {
            emitter.onSuccess(DateUtil.getNowDate());
//            emitter.onComplete();
        });

        maybe.subscribe(
                data -> Logger.osc("# 현재 날짜시각: " + data),
                error -> Logger.oe(error),
                () -> Logger.oc()
        );
    }
}
