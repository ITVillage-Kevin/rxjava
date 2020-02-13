package com.itvillage.chapter05.chapter0502;

import com.itvillage.common.CarMaker;
import io.reactivex.Observable;

/**
 * 유일한 값을 처리하고자 할때 사용
 */
public class ObservableDistinctExample01 {
    public static void main(String[] args) {
        CarMaker[] carMakers = {
                CarMaker.CHEVROLET,
                CarMaker.CHEVROLET,
                CarMaker.HYUNDAE,
                CarMaker.SAMSUNG,
                CarMaker.HYUNDAE,
                CarMaker.SSANGYOUN,
                CarMaker.KIA,
                CarMaker.SSANGYOUN
        };

        Observable.fromArray(carMakers)
                .distinct()
                .subscribe(carMaker -> System.out.println(carMaker));
    }
}
