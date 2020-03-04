package com.itvillage.chapter05.chapter0502.quiz;

import com.itvillage.common.CarMaker;
import com.itvillage.common.SampleData;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * filter를 이용하여 SampleData.carList 중에서 CarMaker가 SSANGYOUNG인 차들의 carName을 출력하세요.
 */
public class QuizAnswerForChapter050201 {
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .filter(car -> car.getCarMaker().equals(CarMaker.SSANGYOUNG))
                .subscribe(car -> Logger.log(LogType.ON_NEXT, car.getCarName()));
    }
}
