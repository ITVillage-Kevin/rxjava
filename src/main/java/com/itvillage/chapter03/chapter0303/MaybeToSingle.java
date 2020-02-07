package com.itvillage.chapter03.chapter0303;

import com.itvillage.utils.DateUtil;
import com.itvillage.utils.Logger;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class MaybeToSingle {
    public static void main(String[] args){
        Single<String> single = Single.just(DateUtil.getNowDate());
        Maybe.fromSingle(single)
                .subscribe(
                        data -> Logger.osc("# 현재 날짜시각: " + data),
                        error -> Logger.oe(error),
                        () -> Logger.oc()
                );
    }

}
