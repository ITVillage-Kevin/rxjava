package com.itvillage.chapter05.chapter0502;

import com.itvillage.common.CarMaker;
import com.itvillage.common.SampleData;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

public class ObservableDistinctExample02 {
    public static void main(String[] args) {
        Observable.fromArray(SampleData.carMakersDuplicated)
                .distinct()
                .filter(carMaker -> carMaker == CarMaker.SSANGYOUNG)
                .subscribe(carMaker -> Logger.log(LogType.ON_NEXT, carMaker));
    }
}
