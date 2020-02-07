package com.itvillage.chapter03.chapter0303;

import com.itvillage.utils.DateUtil;
import com.itvillage.utils.Logger;
import io.reactivex.Flowable;
import io.reactivex.Single;

public class SingleJustExample {
    public static void main(String[] args){
        Single.just(DateUtil.getNowDate())
                .subscribe(
                        data -> Logger.osc("# 날짜시각: " + data),
                        error -> Logger.oe(error)
                );
    }
}
