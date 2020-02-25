package com.itvillage.chapter05.chapter0508;

import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * amb를 이용하여 가장 먼저 통지되는 Observable을 선택하여 통지하는 예제
 */
public class ObservableAmbExample {
    public static void main(String[] args) {

        List<Observable<Integer>> observables = Arrays.asList(
                Observable.fromIterable(SampleData.salesOfBranchA)
                        .delay(200L, TimeUnit.MILLISECONDS)
                        .doOnComplete(() -> Logger.doc("# branch A's sales")),
                Observable.fromIterable(SampleData.salesOfBranchB)
                        .delay(300L, TimeUnit.MILLISECONDS)
                        .doOnComplete(() -> Logger.doc("# branch B's sales")),
                Observable.fromIterable(SampleData.salesOfBranchC)
                        .delay(500L, TimeUnit.MILLISECONDS)
                        .doOnComplete(() -> Logger.doc("# branch C's sales"))
        );

        Observable.amb(observables)
                .doOnComplete(() -> Logger.doc("# 완료"))
                .subscribe(Logger::on);

        TimeUtil.sleep(1000L);
    }
}
