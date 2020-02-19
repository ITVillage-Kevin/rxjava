package com.itvillage.chapter05.chapter0505;

import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableConcatExample02 {
    public static void main(String[] args) {
        Observable<String> observable1 = SampleData.getSpeedPerSection("A", 55L, SampleData.speedOfSectionA);
        Observable<String> observable2 = SampleData.getSpeedPerSection("B", 100L, SampleData.speedOfSectionB);
        Observable<String> observable3 = SampleData.getSpeedPerSection("C", 77L, SampleData.speedOfSectionC);

        Observable.concat(observable1, observable2, observable3)
                .subscribe(Logger::on);

        TimeUtil.sleep(2000L);
    }
}
