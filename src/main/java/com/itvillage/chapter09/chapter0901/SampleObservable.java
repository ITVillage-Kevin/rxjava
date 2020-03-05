package com.itvillage.chapter09.chapter0901;

import com.itvillage.common.CarMaker;
import com.itvillage.common.SampleData;
import io.reactivex.Observable;

public class SampleObservable {
    public Observable<CarMaker> getCarMakerStream(){
        Observable<CarMaker> observable = Observable.fromArray(SampleData.carMakers);
        return observable;
    }
}
