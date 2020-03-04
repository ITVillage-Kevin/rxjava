package com.itvillage.chapter05.chapter0505;

import com.itvillage.common.SampleData;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.NumberUtil;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * 랜덤 온도 데이터와 습도 데이터를 최신 데이터로 가져오는 예제
 */
public class ObservableCombineLatestExample02 {
    public static void main(String[] args) {
        // 랜덤 온도 데이터
        Observable<Integer> observable1 = Observable.interval(NumberUtil.randomRange(100, 500), TimeUnit.MILLISECONDS)
                .take(10)
                .map(notUse -> SampleData.temperatureOfSeoul[NumberUtil.randomRange(0, 5)]);

        // 랜덤 습도 데이터
        Observable<Integer> observable2 = Observable.interval(NumberUtil.randomRange(100, 500), TimeUnit.MILLISECONDS)
                .take(10)
                .map(notUse -> SampleData.humidityOfSeoul[NumberUtil.randomRange(0, 5)]);

        Observable.combineLatest(observable1, observable2,
                (temperature, humidity) -> "최신 온습도 데이터 - 온도: " + temperature + "도\t습도: " + humidity + "%")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(3000L);
    }
}
