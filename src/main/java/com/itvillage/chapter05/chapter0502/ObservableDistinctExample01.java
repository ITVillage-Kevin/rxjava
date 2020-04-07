package com.itvillage.chapter05.chapter0502;

import com.itvillage.common.SampleData;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * 이미 통지한 데이터와 같은 데이터는 제외하고 통지
 * 유일한 값을 처리하고자 할때 사용
 */
public class ObservableDistinctExample01 {
    public static void main(String[] args) {
        Observable.fromArray(SampleData.carMakersDuplicated)
                .distinct()
                .subscribe(carMaker -> Logger.log(LogType.ON_NEXT, carMaker));
    }
}
