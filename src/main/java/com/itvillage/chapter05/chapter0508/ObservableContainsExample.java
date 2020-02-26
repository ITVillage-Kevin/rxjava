package com.itvillage.chapter05.chapter0508;

import com.itvillage.common.CarMaker;
import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * 통지된 데이터 중에 파라미터로 입력한 조건에 맞는 데이터가 있는지 판단하는 예제
 */
public class ObservableContainsExample {
    public static void main(String[] args) {
        Observable.fromArray(SampleData.carMakersDuplicated)
                .doOnNext(Logger::don)
                .contains(CarMaker.SAMSUNG)
                .materialize()
                .subscribe(Logger::on);
    }
}
