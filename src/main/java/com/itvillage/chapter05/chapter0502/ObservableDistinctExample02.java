package com.itvillage.chapter05.chapter0502;

import com.itvillage.common.CarMaker;
import io.reactivex.Observable;

public class ObservableDistinctExample02 {
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
                .filter(carMaker -> carMaker == CarMaker.SSANGYOUN)
                .subscribe(System.out::println);
    }
}
