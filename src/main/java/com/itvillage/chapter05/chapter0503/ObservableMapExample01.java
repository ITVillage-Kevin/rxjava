package com.itvillage.chapter05.chapter0503;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

/**
 * Observable이 통지한 항목에 함수를 적용하여 통지된 값을 변환시킨다.
 */
public class ObservableMapExample01 {
    public static void main(String[] args){
        List<Integer> oddList = Arrays.asList(1, 3, 5, 7);
        Observable.fromIterable(oddList)
                .map(num -> "1을 더한 결과: " + (num + 1))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
