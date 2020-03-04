package com.itvillage.chapter05.chapter0505;

import com.itvillage.common.SampleData;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

/**
 * 3개의 Observable에서 통지된 순서와 상관없이 Observable이 concat( )에
 * 입력된 순서대로 각 구간의 차량 속도 데이터를 이어 붙여 출력하는 예제
 */
public class ObservableConcatExample02 {
    public static void main(String[] args) {
        List<Observable<String>> speedPerSectionList = Arrays.asList(
                SampleData.getSpeedPerSection("A", 55L, SampleData.speedOfSectionA),
                SampleData.getSpeedPerSection("B", 100L, SampleData.speedOfSectionB),
                SampleData.getSpeedPerSection("C", 77L, SampleData.speedOfSectionC)
        );

        Observable.concat(speedPerSectionList)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(2000L);
    }
}
